import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {

        // Tìm phần tử lớn nhất trong mảng
        Scanner sc = new Scanner(System.in);

        int [] arr = new int [5];

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            System.out.printf("numbers[%d]= ", i);
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.print("Mảng gồm các phần tử:");

        for (int i = 0; i < n; i++) {
            System.out.printf(" %d ",arr[i]);
        }

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
            System.out.printf(" %d ",arr[i]);
        }
        System.out.print("\nPhần tử lớn nhất trong mảng là:");
        System.out.printf(" %d ",arr[0]);

    }
}