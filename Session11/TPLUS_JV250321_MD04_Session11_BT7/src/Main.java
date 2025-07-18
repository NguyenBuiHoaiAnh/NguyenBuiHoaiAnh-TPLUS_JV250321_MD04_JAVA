import business.ManageImp;
import entity.Invoice;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManageImp manager = new ManageImp();
        boolean exit = false;

        do {
            System.out.println("************** MENU QUẢN LÝ HÓA ĐƠN ***************");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã hóa đơn: ");
                    String code = scanner.nextLine();

                    double amount;
                    while (true) {
                        System.out.print("Nhập số tiền: ");
                        amount = Double.parseDouble(scanner.nextLine());
                        if (amount >= 0) {
                            break;
                        }
                        System.out.println("Vui lòng nhập số thực >= 0 !");

                    }

                    manager.add(new Invoice(code, amount));
                    System.out.println("Hóa đơn đã được thêm thành công.");
                    break;

                case 2:
                    manager.display();
                    System.out.print("Nhập id hóa đơn cần sửa: ");
                    int updateId = Integer.parseInt(scanner.nextLine()) - 1;

                    System.out.print("Nhập mã hóa đơn mới: ");
                    String newCode;
                    while (true) {
                        newCode = scanner.nextLine();
                        if (!newCode.isEmpty()) {
                            break;
                        }
                        System.out.println("Vui lòng không để trống !");
                        System.out.print("Nhập mã hóa đơn mới: ");
                    }

                    double newAmount;
                    while (true) {
                        System.out.print("Nhập số tiền mới: ");
                        newAmount = Double.parseDouble(scanner.nextLine());
                        if (newAmount >= 0) {
                            break;
                        }
                        System.out.println("Vui lòng nhập số thực >= 0 !");
                    }

                    manager.update(updateId, new Invoice(newCode, newAmount));
                    System.out.println("Hóa đơn đã được sửa thành công.");
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập id hóa đơn cần xóa: ");
                    int deleteId = Integer.parseInt(scanner.nextLine()) - 1;
                    manager.delete(deleteId);
                    System.out.println("Hóa đơn đã được xóa thành công.");
                    break;

                case 4:
                    manager.display();
                    break;

                case 5:
                    exit = true;
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (exit);
    }
}