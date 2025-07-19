package ShopList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CategoryManagement manager = new CategoryManagement();

        int id;
        String name;
        String desc;

        do {
            System.out.println("Menu:");
            System.out.println("1: Thêm danh mục");
            System.out.println("2: Hiển thị danh mục");
            System.out.println("3: Cập nhật danh mục");
            System.out.println("4: Xóa danh mục");
            System.out.println("5: Thoát");

            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID danh mục: ");
                    id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập tên danh mục: ");
                    name = sc.nextLine();

                    System.out.print("Nhập mô tả danh mục: ");
                    desc = sc.nextLine();

                    manager.addCategory(new Category(id, name, desc));
                    break;

                case 2:
                    System.out.println("Danh sách danh mục:");
                    Category[] list = manager.findAll();
                    for (Category c : list) {
                        System.out.println("ID: " + c.getId() + ", Name: " + c.getName() + ", Description: " + c.getDescription());
                    }
                    break;

                case 3:
                    System.out.print("Nhập ID danh mục cần cập nhật: ");
                    id = Integer.parseInt(sc.nextLine());

                    System.out.print("Nhập tên mới: ");
                    name = sc.nextLine();

                    System.out.print("Nhập mô tả mới: ");
                    desc = sc.nextLine();

                    manager.updateCategory(new Category(id, name, desc));
                    break;

                case 4:
                    System.out.print("Nhập ID danh mục cần xóa: ");
                    id = Integer.parseInt(sc.nextLine());
                    manager.deleteById(id);
                    break;

                case 5:
                    System.exit(0);
                    break;
            }

            System.out.println();
        } while (true);
    }
}
