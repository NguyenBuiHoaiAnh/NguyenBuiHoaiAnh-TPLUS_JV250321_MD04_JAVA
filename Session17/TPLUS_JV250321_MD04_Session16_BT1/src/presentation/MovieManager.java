package presentation;

import java.util.Scanner;

public class MovieManager {
    public void MvManagement(Scanner scanner) {

        boolean isExit = false;

        do {
            System.out.println("*********** Movie Management Menu ***********");
            System.out.println("1. Thêm mới phim");
            System.out.println("2. Cập nhật thông tin phim");
            System.out.println("3. Xóa phim");
            System.out.println("4. Lấy danh sách phim");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    isExit = true;
                    break;
            }

        } while (isExit);
    }
}
