import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

        // Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            // Hoán đổi phần tử lớn nhất với phần tử sau
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println("\nMảng sau khi sắp xếp giảm dần:");
        for (int i = 0; i < n; i++) {
            System.out.printf(" %d ", arr[i]);
        }


        // Nhập số cần tìm
        System.out.print("\nNhập số cần tìm: ");
        int search = Integer.parseInt(sc.nextLine());

        //  Tìm kiếm tuyến tính

        boolean linearFound = false;

        for (int i = 0; i < n; i++) {
            if (arr[i] == search) {

                System.out.println("\nTìm kiếm tuyến tính:");
                System.out.printf("\nPhần tử %d tìm thấy tại chỉ số: %d", search, i);
                linearFound = true;
                break;
            }

            if (!linearFound) {
                System.out.printf("\nPhần tử %d tìm thấy tại chỉ số: Không tìm thấy", search);
            }
        }

        // Tìm kiếm nhị phân
        boolean found = false;

        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] == search) {
                    System.out.printf("Tìm kiếm nhị phân: Phần tử %d tìm thấy tại chỉ số: %d", search, mid);
                    found = true;
                    break;
                } else if (arr[mid] < search) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        if (!found) {
            System.out.printf("Phần tử %d tìm thấy tại chỉ số: Không tìm thấy", search);
        }
    }
}
