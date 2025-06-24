import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        // Tính tổng các số từ 1 đến N

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n");
        int n = sc.nextInt();
        int sum = 0;

        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            System.out.println("Kết quả: " + sum);
        } else {
            System.out.println("“Số nhập vào không hợp lệ”.");
        }
    }
}