import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        //  Tính tổng các chữ số của một số nguyên

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        n = Math.abs(n);
        int sum = 0;

        while (n % 10 != 0) {
            sum += n % 10;
            n = n / 10;
        }
        System.out.println("Sum = " + sum);
    }
}