import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Tạo mã giả ngẫu nhiên

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài chuỗi cần tạo: ");
        int n = sc.nextInt();
        // Tạo mảng 62 ký tự: A-Z, a-z, 0-9
        char[] chars = new char[62];
        int index = 0;

        // Chữ in hoa A-Z
        for (char c = 'A'; c <= 'Z'; c++) {
            chars[index++] = c;
        }

        // Chữ thường a-z
        for (char c = 'a'; c <= 'z'; c++) {
            chars[index++] = c;
        }

        // Chữ số 0-9
        for (char c = '0'; c <= '9'; c++) {
            chars[index++] = c;
        }

        // Dùng StringBuilder để nối chuỗi hiệu quả
        StringBuilder result = new StringBuilder(n);

        // Sinh chuỗi ngẫu nhiên
        for (int i = 0; i < n; i++) {
            int randomIndex = (int) (Math.random() * 62); // chỉ số từ 0–61
            result.append(chars[randomIndex]);            // thêm ký tự tương ứng
        }

        System.out.println("Chuỗi ngẫu nhiên: " + result.toString());

    }
}