import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jv250321_person";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345678";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            while (true) {
                System.out.println("\n------ STUDENT MANAGEMENT ------");
                System.out.println("1. Get all students");
                System.out.println("2. Add a student");
                System.out.println("3. Update a student");
                System.out.println("4. Find student by ID");
                System.out.println("5. Delete a student");
                System.out.println("6. Exit");
                System.out.print("Choose: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> getAllStudents(conn);
                    case 2 -> addStudent(conn, scanner);
                    case 3 -> updateStudent(conn, scanner);
                    case 4 -> findStudentById(conn, scanner);
                    case 5 -> deleteStudent(conn, scanner);
                    case 6 -> {
                        System.out.println("Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 1. Get all students
    public static void getAllStudents(Connection conn) throws SQLException {
        CallableStatement stmt = conn.prepareCall("{CALL get_all_students()}");
        ResultSet rs = stmt.executeQuery();
        System.out.println("\n---- STUDENT LIST ----");
        while (rs.next()) {
            System.out.printf("ID: %d | Name: %s | DOB: %s | Email: %s\n",
                    rs.getInt("student_id"),
                    rs.getString("full_name"),
                    rs.getDate("date_of_birth"),
                    rs.getString("email"));
        }
    }

    // 2. Add student
    public static void addStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter full name: ");
        String name = scanner.nextLine();
        System.out.print("Enter date of birth (yyyy-mm-dd): ");
        String dob = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        CallableStatement stmt = conn.prepareCall("{CALL add_student(?, ?, ?)}");
        stmt.setString(1, name);
        stmt.setDate(2, Date.valueOf(dob));
        stmt.setString(3, email);

        stmt.execute();
        System.out.println("Student added successfully.");
    }

    // 3. Update student
    public static void updateStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter student ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter new full name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new date of birth (yyyy-mm-dd): ");
        String dob = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        CallableStatement stmt = conn.prepareCall("{CALL update_student(?, ?, ?, ?)}");
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.setDate(3, Date.valueOf(dob));
        stmt.setString(4, email);

        int rows = stmt.executeUpdate();
        System.out.println("Student updated successfully.");
    }

    // 4. Find student by ID
    public static void findStudentById(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter student ID to find: ");
        int id = Integer.parseInt(scanner.nextLine());

        CallableStatement stmt = conn.prepareCall("{CALL find_student_by_id(?)}");
        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            System.out.println("Student found:");
            System.out.printf("ID: %d | Name: %s | DOB: %s | Email: %s\n",
                    rs.getInt("student_id"),
                    rs.getString("full_name"),
                    rs.getDate("date_of_birth"),
                    rs.getString("email"));
        } else {
            System.out.println("Student not found.");
        }
    }

    // 5. Delete student
    public static void deleteStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter student ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        CallableStatement stmt = conn.prepareCall("{CALL delete_student(?)}");
        stmt.setInt(1, id);

        stmt.execute();
        System.out.println("Student deleted successfully.");
    }
}