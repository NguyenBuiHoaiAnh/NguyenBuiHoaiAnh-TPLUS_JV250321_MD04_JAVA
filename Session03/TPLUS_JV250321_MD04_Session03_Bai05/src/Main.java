import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Tính Tổng Các Số Chẵn và Tổng Các Số Lẻ Trong Mảng 2 Chiều

        Scanner sc = new Scanner(System.in);
        // Nhập số hàng và số cột
        System.out.print("Nhập số hàng: ");
        int rows = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập số cột: ");
        int cols = Integer.parseInt(sc.nextLine());

        // Khởi tạo mảng 2 chiều
        int[][] arr = new int[rows][cols];

        // Nhập giá trị cho mảng theo từng hàng
        System.out.println("Nhập giá trị cho từng phần tử của mảng:");
        for (int i = 0; i < rows; i++) {
            System.out.printf("Hàng %d: ", i + 1);
            for (int j = 0; j < cols; j++) {
                arr[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        System.out.println("Mảng khởi tạo: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%d ",arr[i][j]);
            }
        }

        int sumChan = 0;
        int sumLe = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] % 2 == 0) {
                    sumChan += arr[i][j];
                } else {
                    sumLe += arr[i][j];
                }
            }
        }
        System.out.println("Tổng các số chẵn là: " + sumChan);
        System.out.println("Tổng các số lẻ là: " + sumLe);

    }
}