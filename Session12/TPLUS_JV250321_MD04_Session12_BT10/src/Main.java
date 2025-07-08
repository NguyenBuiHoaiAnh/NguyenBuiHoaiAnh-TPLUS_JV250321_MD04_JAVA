import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.println("Nhập số lượng sinh viên:");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= n; i++) {
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Tên: ");
            String name = sc.nextLine();
            System.out.print("Điểm trung bình: ");
            double avgScore = Double.parseDouble(sc.nextLine());

            students.add(new Student(id, name, avgScore));
        }

        System.out.println("\n===== DANH SÁCH SINH VIÊN PHÂN LOẠI =====");
        for (Student sv : students) {
            sv.printInfo();
        }


    }
}