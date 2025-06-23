import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Tính tổng hai phân số
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập a:");
        int a = sc.nextInt();
        System.out.println("Nhập b:");
        int b = sc.nextInt();
        System.out.println("Nhập c:");
        int c = sc.nextInt();
        System.out.println("Nhập d:");
        int d = sc.nextInt();

        int tuSo = a*d + b*c;
        int mauSo = b*d;

        System.out.println("Kết quả: " + tuSo + "/" + mauSo );

    }
}