package BTTH;

import java.util.Scanner;

public class BTTH2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows, cols;
        System.out.println("Nhập vào số hàng: ");
        rows = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào số cột: ");
        cols = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[rows][cols];

        do {
            System.out.println("""
                    *********************MENU********************
                    1. Nhập giá trị các phần tử của mảng
                    2. In giá trị các phần tử tử trong mảng theo ma trận
                    3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng
                    4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và đường chéo phụ
                    5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tử tăng dần theo cột của mảng
                    6. In ra các phần tử là số nguyên tố trong mảng
                    7. Sử dụng thuật toán hoán đổi sắp xếp các phần tử trên đường chéo chính của mảng giảm dần
                    8. Nhập giá trị một mảng 1 chiều gồm m phần tử và chỉ số dòng muốn chèn vào mảng, thực hiện chèn vào mảng 2 chiều
                    9. Thoát
                    *********************************************
                    Lựa chọn của bạn:
                    """);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.printf("Nhập vào phần tử hàng %d cột %d: \n", i + 1, j + 1);
                            matrix[i][j] = Integer.parseInt(sc.nextLine());
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.printf("%3d", matrix[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    int count = 0;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            if (matrix[i][j] % 2 == 0 && matrix[i][j] % 3 == 0) {
                                count++;
                            }
                        }
                    }
                    System.out.println("Số lượng phần tử chia hết cho 2 và 3 là: " + count);
                    break;
                case 4:
                    int sumBorder = 0;
                    int sumCheoChinh = 0;
                    int sumCheoPhu = 0;

                    // Đường biên
                    System.out.println("Các phần tử trên đường biên:");
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                                System.out.print(matrix[i][j] + " ");
                                sumBorder += matrix[i][j];
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }

                    if (rows == cols) {
                        // Đường chéo chính
                        System.out.println("\n Các phần tử trên đường chéo chính:");
                        for (int i = 0; i < cols; i++) {
                            System.out.println("matrix[" + i + "][" + i + "] = " + matrix[i][i]);
                            sumCheoChinh += matrix[i][i];
                        }

                        // Đường chéo phụ
                        System.out.println("\n Các phần tử trên đường chéo phụ:");
                        for (int i = 0; i < cols; i++) {
                            System.out.println("matrix[" + i + "][" + (cols - 1 - i) + "] = " + matrix[i][cols - 1 - i]);
                            sumCheoPhu += matrix[i][cols - 1 - i];
                        }
                    }

                    // Xuất tổng
                    System.out.println("-> Đường biên: " + sumBorder);
                    System.out.println("-> Đường chéo chính: " + sumCheoChinh);
                    System.out.println("-> Đường chéo phụ: " + sumCheoPhu);
                    break;
                case 5:
                    for (int i = 0; i < cols; i++) {
                        for (int j = 0; j < rows - 1; j++) {
                            for (int k = j + 1; k < rows; k++) {
                                if (matrix[j][i] > matrix[k][i]) {
                                    int temp = matrix[j][i];
                                    matrix[j][i] = matrix[k][i];
                                    matrix[k][i] = temp;
                                }
                            }
                        }
                    }
                    break;
                case 6:

                    break;
                case 7:
                    int length = rows < cols ? rows : cols;

                    for (int i = 0; i < length - 1; i++) {
                        for (int j = i + 1; j < length; j++) {
                            if (matrix[i][i] < matrix[j][j]) {
                                int temp = matrix[i][i];
                                matrix[i][i] = matrix[j][j];
                                matrix[j][j] = temp;
                            }
                        }
                    }

                    break;
                case 8:
                    System.out.println("Nhập vào vị trí muốn chèn: ");
                    int insertRow = Integer.parseInt(sc.nextLine());
                    if (insertRow > 0 && insertRow <= rows) {
                        int[][] newMatrix = new int[rows + 1][cols];

                        for (int i = 0; i < rows + 1; i++) {
                            for (int j = 0; j < cols; j++) {
                                if (i < insertRow - 1) {
                                    newMatrix[i][j] = matrix[i][j];
                                } else if (i == insertRow - 1) {
                                    System.out.println("Nhập vào phần tử: ");
                                    newMatrix[i][j] = Integer.parseInt(sc.nextLine());
                                } else {
                                    newMatrix[i][j] = matrix[i - 1][j];
                                }
                            }
                        }

                        matrix = newMatrix;
                        rows++;

                    } else {
                        System.err.println("Số hàng không hợp lệ");
                    }
                    break;
                case 9:
                    break;
                default:
                    System.err.println("Vui lòng nhập lại từ 1 -> 9");
            }
        }
        while (true);
    }
}