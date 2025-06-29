import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Quản lý danh sách từ vựng Tiếng Anh
        Scanner sc = new Scanner(System.in);
        String wordList = "";
        String[] arr = wordList.trim().split("\n");

        do {
            System.out.println("""
                    ======= QUẢN LÝ TỪ VỰNG TIẾNG ANH =======
                    
                    1. Thêm từ mới
                    
                    2. Hiển thị danh sách từ vựng
                    
                    3. Sửa từ vựng theo vị trí
                    
                    4. Xóa từ vựng theo vị trí
                    
                    5. Tìm từ chứa ký tự người dùng nhập vào
                    
                    6. Đếm số từ bắt đầu bằng chữ cái người dùng nhập vào
                    
                    7. Sắp xếp danh sách từ theo thứ tự A-Z
                    
                    8. Thoát
                    
                    =========================================
                    
                    Chọn:
                    """);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập từ mới: ");
                    String tuMoi = sc.nextLine().trim();

                    wordList += tuMoi + "\n";
                    System.out.println(" Đã thêm.");
                    break;
                case 2:
                    System.out.println("Danh sách từ vựng:\n" + wordList);
                    break;
                case 3:
                    System.out.print("Nhập vị trí cần sửa: ");
                    int fixIndex = sc.nextInt();

                    if (fixIndex >= 1 && fixIndex <= arr.length) {
                        System.out.print("Nhập từ mới: ");
                        String fixWord = sc.nextLine().trim();
                        arr[fixIndex - 1] = fixWord;
                        wordList = "";
                        for (int i = 0; i < arr.length; i++) {
                            wordList += arr[i] + "\n";
                        }
                        System.out.println("Đã sửa.");
                    } else {
                        System.out.println("Vị trí không hợp lệ.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập vị trí cần xoá: ");
                    int deleteIndex = sc.nextInt();

                    if (deleteIndex >= 1 && deleteIndex <= arr.length) {
                        wordList = "";
                        for (int i = 0; i < arr.length; i++) {
                            if (i != deleteIndex - 1) {
                                wordList += arr[i] + "\n";
                            }
                        }
                        System.out.println("Đã xoá.");
                    } else {
                        System.out.println("Vị trí không hợp lệ.");
                    }
                    break;
                case 5:
                    System.out.print("Nhập ký tự hoặc chuỗi cần tìm: ");
                    String findWord = sc.nextLine().toLowerCase();
                    boolean found = false;
                    System.out.println("Kết quả tìm:");
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i].toLowerCase().contains(findWord)) {
                            System.out.println(arr[i]);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy.");
                    }
                    break;
                case 6:
                    System.out.print("Nhập chữ cái bắt đầu: ");
                    char startWord = sc.nextLine().toLowerCase().charAt(0);
                    int cntSW = 0;
                    for (int i = 0; i < arr.length; i++) {
                        if (Character.toLowerCase(arr[i].charAt(0)) == startWord) {
                            cntSW++;
                        }
                    }
                    System.out.println("Có " + cntSW + " từ bắt đầu bằng '" + startWord + "'");
                    break;
                case 7:
                    // Sắp xếp danh sách
                    for (int i = 0; i < arr.length - 1; i++) {
                        int minIndex = i;
                        for (int j = i + 1; j < arr.length; j++) {
                            if (arr[j].compareToIgnoreCase(arr[minIndex]) < 0) {
                                minIndex = j;
                            }
                        }
                        if (minIndex != i) {
                            // Hoán đổi arr[i] và arr[minIndex]
                            String temp = arr[i];
                            arr[i] = arr[minIndex];
                            arr[minIndex] = temp;
                        }
                    }

                    // Cập nhật lại chuỗi danh sách sau khi sắp xếp
                    wordList = "";
                    for (int i = 0; i < arr.length; i++) {
                        wordList += arr[i] + "\n";
                    }

                    System.out.println("Đã sắp xếp A-Z (Selection Sort).");
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}