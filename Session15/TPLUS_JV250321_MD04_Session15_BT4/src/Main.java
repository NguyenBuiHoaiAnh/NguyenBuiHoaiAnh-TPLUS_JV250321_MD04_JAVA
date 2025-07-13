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
                System.out.println("5. Tìm kiếm sinh viên theo tên");
                System.out.println("6. Thoát");
                System.out.print("Chọn: ");

                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập một số nguyên.");
                    continue;
                }

                switch (choice) {
                    case 1 -> showAllStudents(conn);
                    case 2 -> addStudent(conn, scanner);
                    case 3 -> updateStudent(conn, scanner);
                    case 4 -> deleteStudent(conn, scanner);
                    case 5 -> searchStudentByName(conn, scanner);
                    case 6 -> System.out.println("Đã thoát chương trình.");
                    default -> System.out.println("Lựa chọn không hợp lệ!");
                }
            } while (true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showAllStudents(Connection conn) throws SQLException {
        CallableStatement stmt = conn.prepareCall("{CALL get_all_students()}");
        ResultSet rs = stmt.executeQuery();

        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
        while (rs.next()) {
            printStudent(rs);
        }
    }

    public static void addStudent(Connection conn, Scanner scanner) throws SQLException {
        String name = getNonEmptyInput(scanner, "Nhập họ tên: ");
        String dob = getValidDate(scanner, "Nhập ngày sinh (yyyy-mm-dd): ");
        String email = getNonEmptyInput(scanner, "Nhập email: ");

        CallableStatement stmt = conn.prepareCall("{CALL add_student(?, ?, ?)}");
        stmt.setString(1, name);
        stmt.setDate(2, Date.valueOf(dob));
        stmt.setString(3, email);

        stmt.execute();
        System.out.println("Thêm sinh viên thành công!");
    }

    public static void updateStudent(Connection conn, Scanner scanner) throws SQLException {
        int id = getValidInt(scanner, "Nhập ID sinh viên cần sửa: ");
        String name = getNonEmptyInput(scanner, "Nhập tên mới: ");
        String dob = getValidDate(scanner, "Nhập ngày sinh mới (yyyy-mm-dd): ");
        String email = getNonEmptyInput(scanner, "Nhập email mới: ");

        CallableStatement stmt = conn.prepareCall("{CALL update_student(?, ?, ?, ?)}");
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.setDate(3, Date.valueOf(dob));
        stmt.setString(4, email);

        stmt.execute();
        System.out.println("Cập nhật sinh viên thành công!");
    }

    public static void deleteStudent(Connection conn, Scanner scanner) throws SQLException {
        int id = getValidInt(scanner, "Nhập ID sinh viên cần xóa: ");

        CallableStatement stmt = conn.prepareCall("{CALL delete_student(?)}");
        stmt.setInt(1, id);
        stmt.execute();

        System.out.println("Xóa sinh viên thành công!");
    }

    public static void searchStudentByName(Connection conn, Scanner scanner) throws SQLException {
        String keyword = getNonEmptyInput(scanner, "Nhập tên cần tìm: ");

        CallableStatement stmt = conn.prepareCall("{CALL search_student(?)}");
        stmt.setString(1, keyword);
        ResultSet rs = stmt.executeQuery();

        boolean found = false;
        while (rs.next()) {
            printStudent(rs);
            found = true;
        }

        if (!found) {
            System.out.println("Không tìm thấy sinh viên nào.");
        }
    }

    // In sinh viên
    private static void printStudent(ResultSet rs) throws SQLException {
        System.out.printf("ID: %d | Tên: %s | Ngày sinh: %s | Email: %s\n",
                rs.getInt("student_id"),
                rs.getString("full_name"),
                rs.getDate("date_of_birth"),
                rs.getString("email"));
    }

    // ==== Tiện ích kiểm tra đầu vào ====

    private static int getValidInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên hợp lệ.");
            }
        }
    }

    private static String getValidDate(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                Date.valueOf(input); // kiểm tra định dạng yyyy-mm-dd
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println("Định dạng ngày không hợp lệ. Vui lòng nhập yyyy-mm-dd.");
            }
        }
    }

    private static String getNonEmptyInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.println("Không được để trống.");
        }
    }
}