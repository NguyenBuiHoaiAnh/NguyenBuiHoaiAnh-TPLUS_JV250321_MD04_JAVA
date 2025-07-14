package presentation;

import java.util.Scanner;

public class BookTypeManagement {
    public void bookTypeManagement(Scanner scanner) {
        System.out.println("""
                ********************BOOK TYPE****************\s
                1. Danh sách loại sách\s
                2. Thêm mới loại sách\s
                3. Cập nhật loại sách\s
                4. Xóa loại sách\s
                5. Thoát\s
                Lựa chọn của bạn:
                """);
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.exit(0);
        }
    }
}
