package presentation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BookManagement bookManagement = new BookManagement();
        BookTypeManagement bookTypeManagement = new BookTypeManagement();

        do {
            System.out.println("""
                    ********************BOOK MANAGEMENT****************\s
                    1. Quản lý loại sách\s
                    2. Quản lý sách\s
                    3. Thoát\s
                    Lựa chọn của bạn:
                    """);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    bookManagement.bookManagement(scanner);
                    break;
                case 2:
                    bookTypeManagement.bookTypeManagement(scanner);
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }
}