package presentation;

import entity.Book;

import java.util.Scanner;

public class BookManagement {
    public void bookManagement(Scanner scanner) {

        System.out.println("""
                ********************BOOK****************\s
                1. Danh sách sách\s
                2. Thêm mới sách\s
                3. Thêm mới nhiều sách\s
                4. Cập nhật sách\s
                5. Xóa sách\s
                6. Tìm kiếm sách\s
                7. Thông kê số lượng sách theo tác giả\s
                8. Thoát\s
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
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                System.exit(0);
        }
    }
}
