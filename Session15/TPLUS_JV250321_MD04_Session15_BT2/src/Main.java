import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/jv250321_person";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "12345678";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            int choice;
            do {
                System.out.println("\n========= MENU =========");
                System.out.println("1. Hiển thị danh sách sinh viên");
                System.out.println("2. Thêm mới sinh viên");
                System.out.println("3. Sửa sinh viên");
                System.out.println("4. Xóa sinh viên");
                System.out.println("5. Tìm kiếm sinh viên theo ID");
                System.out.println("6. Thoát");
                System.out.print("Chọn: ");
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> showAllStudents(conn);
                    case 2 -> addStudent(conn, scanner);
                    case 3 -> updateStudent(conn, scanner);
                    case 4 -> deleteStudent(conn, scanner);
                    case 5 -> findStudent(conn, scanner);
                    case 6 -> System.out.println("Đã thoát chương trình.");
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            } while (choice != 6);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showAllStudents(Connection conn) throws SQLException {
        CallableStatement stmt = conn.prepareCall("{CALL get_all_students()}");
        ResultSet rs = stmt.executeQuery();

        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
        while (rs.next()) {
            System.out.printf("ID: %d | Tên: %s | Ngày sinh: %s | Email: %s\n",
                    rs.getInt("student_id"),
                    rs.getString("full_name"),
                    rs.getDate("date_of_birth"),
                    rs.getString("email"));
        }
    }

    public static void addStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Nhập họ tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh (yyyy-mm-dd): ");
        String dob = scanner.nextLine();
        System.out.print("Nhập email: ");
        String email = scanner.nextLine();

        CallableStatement stmt = conn.prepareCall("{CALL add_student(?, ?, ?)}");
        stmt.setString(1, name);
        stmt.setDate(2, Date.valueOf(dob));
        stmt.setString(3, email);

        stmt.execute();
        System.out.println("Thêm sinh viên thành công!");
    }

    public static void updateStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Nhập ID sinh viên cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập tên mới: ");
        String name = scanner.nextLine();
        System.out.print("Nhập ngày sinh mới (yyyy-mm-dd): ");
        String dob = scanner.nextLine();
        System.out.print("Nhập email mới: ");
        String email = scanner.nextLine();

        CallableStatement stmt = conn.prepareCall("{CALL update_student(?, ?, ?, ?)}");
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.setDate(3, Date.valueOf(dob));
        stmt.setString(4, email);

        stmt.execute();
        System.out.println("Cập nhật sinh viên thành công!");
    }

    public static void deleteStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Nhập ID sinh viên cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());

        CallableStatement stmt = conn.prepareCall("{CALL delete_student(?)}");
        stmt.setInt(1, id);
        stmt.execute();

        System.out.println("Xóa sinh viên thành công!");
    }

    public static void findStudent(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Nhập ID sinh viên cần tìm: ");
        int id = Integer.parseInt(scanner.nextLine());

        CallableStatement stmt = conn.prepareCall("{CALL find_student_by_id(?)}");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            System.out.println("\n--- THÔNG TIN SINH VIÊN ---");
            System.out.printf("ID: %d | Tên: %s | Ngày sinh: %s | Email: %s\n",
                    rs.getInt("student_id"),
                    rs.getString("full_name"),
                    rs.getDate("date_of_birth"),
                    rs.getString("email"));
        } else {
            System.out.println("Không tìm thấy sinh viên có ID = " + id);
        }
    }
}