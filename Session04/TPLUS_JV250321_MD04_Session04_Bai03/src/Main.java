import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Thay thế ký tự trong chuỗi

        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào một chuỗi: ");
        String text = sc.nextLine();

        // Thay thế tất cả các ký tự số bằng dấu *
        String replaced = text.replaceAll("[0-9]", "*");

        System.out.println("Chuỗi sau khi thay thế: " + replaced);

    }
}