package presentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MovieManager movieManager = new MovieManager();

        do {
            System.out.println("*************** Cinema Management ***************");
            System.out.println("1. Quản Lý Phim");
            System.out.println("2. quản lý Lịch Chiếu");
            System.out.println("3. Quản lý Vé");
            System.out.println("Lựa chọn của bạn:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    movieManager.MvManagement(scanner);
                    break;
                case 2:
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.err.println("Chọn từ 1 đến 3");
            }

        } while (true);
    }
}