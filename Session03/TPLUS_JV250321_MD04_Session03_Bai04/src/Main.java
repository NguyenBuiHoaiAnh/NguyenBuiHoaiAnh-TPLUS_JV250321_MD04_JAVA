import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = Integer.parseInt(sc.nextLine());

        if (l <= 0) {
            System.out.println("Kích thước rỗng");
            return;
        }

        int[] arr = new int[l];

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.printf("numbers[%d]= ", i);
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Mảng gồm các phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.printf(" %d ", arr[i]);
        }


        for (int i = 0; i < n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
        System.out.println("\nMảng sau khi đảo ngược:");
        for (int i = 0; i < n; i++) {
            System.out.printf(" %d ", arr[i]);
        }


    }
}