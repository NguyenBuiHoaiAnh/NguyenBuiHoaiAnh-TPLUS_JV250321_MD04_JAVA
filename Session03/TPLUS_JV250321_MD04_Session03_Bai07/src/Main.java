import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập kích thước mảng: ");
        int l = Integer.parseInt(sc.nextLine());

        if (l <= 0) {
            System.out.println("Mảng không hợp lệ");
            return;
        }

        int[] arr = new int[l];
        int[] arr2 = new int[l];

        int n = arr.length;
        int n2 = arr2.length;

        for (int i = 0; i < n; i++) {
            System.out.printf("numbers[%d]= ", i);
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Mảng gồm các phần tử:");
        for (int i = 0; i < n; i++) {
            System.out.printf(" %d ", arr[i]);
        }

        // Loại bỏ tất cả các phần tử trùng lặp.
        for (int i = 0; i < n; i++) {
            boolean check = false;

            for (int j = 0; j < n2; j++) {
                if (arr[i] == arr2[j]) {
                    check = true;
                    break;
                }
            }
            if (check != true) {
                for (int j = 0; j < n2; j++) {
                    arr2[j] = arr[i];
                }
            }
        }

        // In kết quả
        if (n2 <= 0) {
            System.out.println("Không có phần tử nào duy nhất trong mảng");
        } else {
            System.out.print("Mảng sau khi loại bỏ phần tử trùng lặp: ");
            for (int i = 0; i < n2; i++) {
                System.out.printf(" %d ", arr2[i]);

            }
        }
    }
}