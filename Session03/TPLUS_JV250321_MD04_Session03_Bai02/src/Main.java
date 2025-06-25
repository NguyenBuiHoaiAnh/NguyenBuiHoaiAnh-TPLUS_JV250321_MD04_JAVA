import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Tính tổng các phần tử trong mảng

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kích thước mảng: ");
        int n = Integer.parseInt(sc.nextLine());

        int [] arr = new int [n];
        int l = arr.length;

        for (int i = 0; i < l; i++) {
            System.out.printf("numbers[%d]= ", i);
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Mảng gồm các phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.printf(" %d ",arr[i]);
        }

        // Tính tổng các phần tử
        int sumElement = 0;
        for (int element : arr) {
            sumElement += element;
        }
        System.out.println("\nTổng các phần tử là: " + sumElement);
    }
}