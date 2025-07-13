package ra.presentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ra.entity.Student;

public class StudentManagement {
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("*********************QUẢN LÝ SINH VIÊN********************");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật thông tin sinh viên theo mã");
            System.out.println("4. Xóa sinh viên theo mã");
            System.out.println("5. Tìm sinh viên theo tên");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    showStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    searchStudentByName();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 6);
    }

    private static void showStudents() {
        if (studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên trống.");
        } else {
            for (Student s : studentList) {
                s.displayData();
            }
        }
    }

    private static void addStudent() {
        Student s = new Student();
        s.inputData(scanner);
        studentList.add(s);
        System.out.println("Đã thêm sinh viên.");
    }

    private static void updateStudent() {
        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        String id = scanner.nextLine();
        Student student = findById(id);
        if (student != null) {
            System.out.println("Nhập thông tin mới:");
            student.inputData(scanner);
            System.out.println("Cập nhật thành công.");
        } else {
            System.out.println("Không tìm thấy sinh viên có mã " + id);
        }
    }

    private static void deleteStudent() {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = scanner.nextLine();
        Student student = findById(id);
        if (student != null) {
            studentList.remove(student);
            System.out.println("Đã xóa sinh viên.");
        } else {
            System.out.println("Không tìm thấy sinh viên có mã " + id);
        }
    }

    private static void searchStudentByName() {
        System.out.print("Nhập tên sinh viên cần tìm: ");
        String name = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (Student s : studentList) {
            if (s.getStudentName().toLowerCase().contains(name)) {
                s.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên có tên chứa \"" + name + "\"");
        }
    }

    private static Student findById(String id) {
        for (Student s : studentList) {
            if (s.getStudentId().equalsIgnoreCase(id)) {
                return s;
            }
        }
        return null;
    }
}
