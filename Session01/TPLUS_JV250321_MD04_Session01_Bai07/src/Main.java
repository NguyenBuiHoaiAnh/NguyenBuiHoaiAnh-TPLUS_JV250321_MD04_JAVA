import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        // Tìm ra năm sinh người dùng nhập vào tuổi

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập age:");
        int age = Integer.parseInt(sc.nextLine());

        int cunrrentYear = 2025;
        int yob = 2025 - age;

        if (age > 0) {
            System.out.println("Năm sinh:" + yob);
        } else {
            System.out.println("Không hợp lệ");
        }
    }
}