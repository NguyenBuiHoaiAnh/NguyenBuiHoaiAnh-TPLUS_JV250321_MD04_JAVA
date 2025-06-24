import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        // Kiểm tra số chẵn lẻ
        /*
        Nhập một số nguyên từ bàn phím.
        Sử dụng câu lệnh if-else để xác định số đó
        là chẵn hay lẻ.
        Trường hợp số là 0, hiển thị thông báo:
        "Số không phải chẵn cũng không phải lẻ".
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số nguyên:");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Số không phải chẵn cũng không phải lẻ");
        } else if (n % 2 == 0) {
            System.out.printf("Số %d là số chẵn",n);
        } else {
            System.out.printf("Số %d là số lẻ",n);
        }

    }
}