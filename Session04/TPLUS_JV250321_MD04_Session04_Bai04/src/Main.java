import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Kiểm tra định dạng email

        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine().trim();

//       String emailRegex = "^[a-zA-Z0-9.-]@[a-zA-Z0-9.-]\\.[a-zA-Z]{2,6}$";
        String emailRegex = "^[\\w.-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

        if (Pattern.matches(emailRegex, email)) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }
    }
}