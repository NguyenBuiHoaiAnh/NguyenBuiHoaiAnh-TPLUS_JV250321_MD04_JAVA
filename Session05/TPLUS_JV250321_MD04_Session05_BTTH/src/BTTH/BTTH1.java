package BTTH;

import java.util.Scanner;

public class BTTH1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập kích thước của mảng:");
        int size = Integer.parseInt(sc.nextLine());
        int[] arr = new int[size];

        int currentIndex = 0;

        do {
            System.out.println("*********************MENU******************** ");
            System.out.println("1. Nhập giá trị n phần tử của mảng (n nhập từ bàn phím)");
            System.out.println("2. In giá trị các phần tử trong mảng ");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong \n" +
                    "mảng (k nhập từ bàn phím)");
            System.out.println("5. Sử dụng thuật toán sắp xếp hoán đổi sắp xếp mảng giảm dần ");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng ");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần, các phần \n" +
                    "tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần, các phần tử còn lại ở giữa \n" +
                    "mảng theo thứ tự tăng dần" +
                    "");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí");
            System.out.println("9. Thoát");
            System.out.println("Lựa chọn của bạn:");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Nhập vào số lượng phần tử cần nhập giá trị:");
                    int n = sc.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.printf("arr[%d]= ", currentIndex);
                        arr[currentIndex] = sc.nextInt();
                        currentIndex++;
                    }
                    break;
                case 2:
                    System.out.println("Mảng khởi tạo:");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%5d", arr[i]);
                    }
                    System.out.println();
                    break;
                case 3:
                    int count = 0;
                    int sumArg = 0;

                    for (int i = 0; i < currentIndex; i++) {
                        if (arr[i] > 0) {
                            sumArg += arr[i];
                            count++;
                        }
                    }
                    System.out.println("Trung bình các phần tử dương: " + sumArg / count);
                    break;
                case 4:
                    System.out.println("Nhập giá trị k để tìm:");
                    int k = sc.nextInt();

                    System.out.println("Vị trí (chỉ số) các phần tử có giá trị bằng k:");
                    for (int i = 0; i < currentIndex; i++) {
                        if (arr[i] == k) {
                            System.out.printf("%5d", i);
                        }
                    }
                    System.out.println();
                    break;
                case 5:
                    for (int i = 0; i < currentIndex - 1; i++) {
                        for (int j = i + 1; j < currentIndex; j++) {
                            if (arr[i] < arr[j]) {
                                int temp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp xong.");
                    break;
                case 6:
                    int cntPrime = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        boolean isPrime = true;
                        if (arr[i] >= 2) {
                            for (int j = 2; j <= Math.sqrt(arr[i]); j++) {
                                if (arr[i] % j == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                        } else {
                            isPrime = false;
                        }
                        if (isPrime) {
                            cntPrime++;
                        }
                    }
                    System.out.println("Số nguyên tố trong mảng:" + cntPrime);
                    break;
                case 7:
                    // 1. Khai báo 3 mảng để lưu trữ
                    int cntOdd = 0;
                    int cntEven = 0;

                    for (int i = 0; i < currentIndex; i++) {
                        if (arr[i] % 2 == 0 && arr[i] % 3 == 0) {
                            cntEven++;
                        } else if (arr[i] % 2 != 0 && arr[i] % 3 == 0) {
                            cntOdd++;
                        }
                    }

                    int[] EvenArr = new int[cntEven];
                    int[] OddArr = new int[cntOdd];
                    int[] OtherArr = new int[currentIndex - cntEven - cntOdd];
                    // 2. Lưu các phần tử ra mảng mới
                    int currentEven = 0;
                    int currentOdd = 0;
                    int currentOther = 0;

                    for (int i = 0; i < currentIndex; i++) {
                        if (arr[i] % 2 == 0 && arr[i] % 3 == 0) {
                            EvenArr[currentEven] = arr[i];
                            currentEven++;
                        } else if (arr[i] % 2 != 0 && arr[i] % 3 == 0) {
                            OddArr[currentOdd] = arr[i];
                            currentOdd++;
                        } else {
                            OtherArr[currentOther] = arr[i];
                            currentOther++;
                        }
                    }
                    // Sắp xếp các mảng
                    // Sắp xếp mảng chẵn chia hết cho 3 tăng dần
                    for (int i = 0; i < EvenArr.length - 1; i++) {
                        for (int j = i + 1; j < EvenArr.length; j++) {
                            if (EvenArr[i] > EvenArr[j]) {
                                int temp = EvenArr[i];
                                EvenArr[i] = EvenArr[j];
                                EvenArr[j] = temp;
                            }
                        }
                    }
                    // Sắp xếp mảng lẻ chia hết cho 3 giảm dần
                    for (int i = 0; i < OddArr.length - 1; i++) {
                        for (int j = i + 1; j < OddArr.length; j++) {
                            if (OddArr[i] < OddArr[j]) {
                                int temp = OddArr[i];
                                OddArr[i] = OddArr[j];
                                OddArr[j] = temp;
                            }
                        }
                    }
                    // Sắp xếp mảng các phẩn tử còn lại tăng dần
                    for  (int i = 0; i < OtherArr.length - 1; i++) {
                        for (int j = i + 1; j < OtherArr.length; j++) {
                            if (OtherArr[i] > OtherArr[j]) {
                                int temp = OtherArr[i];
                                OtherArr[i] = OtherArr[j];
                                OtherArr[j] = temp;
                            }
                        }
                    }
                    // Bê các phần tử ở 3 mảng mới về cũ
                    currentIndex = 0;
                    for (int i = 0; i < EvenArr.length; i++) {
                        arr[currentIndex] = EvenArr[i];
                        currentIndex++;
                    }

                    for (int element : OtherArr) {
                        arr[currentIndex] = element;
                        currentIndex++;
                    }

                    for (int element : OddArr) {
                        arr[currentIndex] = element;
                        currentIndex++;
                    }
                    System.out.println("Đã sắp xếp xong theo yêu cầu.");
                    break;
                case 8:
                    // 1. Sắp xếp mảng giảm dần theo thuật toán selection sort

                    for (int i = 0; i < currentIndex - 1; i++) {
                        int maxIndex = i;
                        for (int j = i + 1; j < currentIndex; j++) {
                            if (arr[maxIndex] < arr[j]) {
                                maxIndex = j;
                            }
                        }
                        if (maxIndex != i) {
                            int temp = arr[maxIndex];
                            arr[maxIndex] = arr[i];
                            arr[i] = temp;
                        }
                    }
                    // 2. Nhập giá trị m cần chèn
                    System.out.println("Nhập giá trị m cần chèn");
                    int m = sc.nextInt();

                    // 3. Chèn m vào mảng ở vị trí thích hợp
                    int indexInsert = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (m >= arr[i]) {
                            indexInsert = i;
                            break;
                        }
                    }

                    for (int i = currentIndex; i > indexInsert; i--) {
                        arr[i] = arr[i - 1];
                    }
                    arr[indexInsert] = m;
                    break;
                case 9:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
