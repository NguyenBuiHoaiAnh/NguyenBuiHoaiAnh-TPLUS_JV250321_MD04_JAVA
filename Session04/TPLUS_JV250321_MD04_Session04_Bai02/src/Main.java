import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Xóa và thay thế phần tử trong StringBuilder

        Scanner sc = new Scanner(System.in);
        String text = "Hello, Java World!";

        System.out.println("Chuỗi ban đầu: " + text);

        StringBuilder sb = new StringBuilder(text);

        // In chuỗi sau khi xóa.
        sb.delete(5,10);
        String deleteStr = sb.toString();
        System.out.println("Chuỗi sau khi xóa: " + deleteStr);

        // In chuỗi sau khi thay thế.
        String replaceStr = deleteStr.replace("World", "Universe");
        System.out.println("Chuỗi sau khi thay thế: " + replaceStr);
    }
}

