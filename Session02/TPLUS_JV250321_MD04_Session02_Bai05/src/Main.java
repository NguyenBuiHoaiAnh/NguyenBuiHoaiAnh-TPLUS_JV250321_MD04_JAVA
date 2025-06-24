import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Nhập một số nguyên từ 1 đến 12:");
            int n = sc.nextInt();

            switch (n) {
                case 1, 3, 5, 7, 8, 10, 12:
                    System.out.printf("Tháng %d có 31 ngày\n", n);
                    break;
                case 4, 6, 9, 11:
                    System.out.printf("Tháng %d có 30 ngày\n", n);
                    break;
                case 2:
                    System.out.printf("Tháng %d có 28 hoặc 29 ngày\n", n);
                    break;
                case -1 :
                    System.exit(0);
                default:
                    System.out.println("Tháng không hợp lệ.");
                    break;
            }
        } while (true);
    }
}