import java.util.Scanner;
import java.util.regex.Pattern;

public  class Main {
    public static void main(String[] args) {
        // Kiểm tra mật khẩu hợp lệ
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mật khẩu:");
        String password = sc.nextLine();

        String passRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$";

        if (Pattern.matches(passRegex, password)) {
            System.out.println("Password hợp lệ");
        } else {
            System.out.println("Password không hợp lệ");
        }
    }
}