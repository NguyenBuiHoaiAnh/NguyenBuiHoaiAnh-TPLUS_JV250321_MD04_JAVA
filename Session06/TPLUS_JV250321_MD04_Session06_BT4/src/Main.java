import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Nhập thông tin sinh viên từ bàn phím
        System.out.print("Nhập tên sinh viên: ");
        String name = sc.nextLine();

        System.out.println("Nhập tuổi: ");
        int age = sc.nextInt();


        System.out.println("Nhập lớp: ");
        String className = sc.nextLine();

        System.out.println("Nhập điểm trung bình: ");
        double avg = sc.nextDouble();

        // Tạo đối tượng và in ra
        Student student = new Student(name, age, className, avg);
        System.out.println("\nThông tin sinh viên:");
        System.out.println(student);  // Gọi toString() tự động

    }
}