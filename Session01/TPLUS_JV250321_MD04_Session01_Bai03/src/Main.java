import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào: ");
        int r = sc.nextInt();
        float A = (float)Math.PI * r * r;
        System.out.printf("Kết quả mong muốn: %f", A);
    }
}