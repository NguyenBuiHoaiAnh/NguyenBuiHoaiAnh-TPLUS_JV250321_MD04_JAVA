import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Sắp xếp mảng giảm dần
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập kích thước mảng:");
        int l = Integer.parseInt(sc.nextLine());

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

        // Sắp xếp nổi bọt
        boolean flag;
        for (int i = 0; i < n - 1; i++) {
            flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
        System.out.println("\nMảng sau khi sắp xếp giảm dần:");
        for (int i = 0; i < n; i++) {
            System.out.printf(" %d ", arr[i]);
        }
    }
}