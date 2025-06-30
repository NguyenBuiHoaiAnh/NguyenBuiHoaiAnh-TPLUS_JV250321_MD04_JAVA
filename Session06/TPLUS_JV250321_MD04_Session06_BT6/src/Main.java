import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Category[] categories = new Category[100]; // tối đa 100 danh mục
        int count = 0;


        do {
            System.out.println("\nMenu:");
            System.out.println("1: Thêm mới danh mục");
            System.out.println("2: Hiển thị danh sách danh mục");
            System.out.println("3: Cập nhật danh mục");
            System.out.println("4: Xóa danh mục");
            System.out.println("5: Tìm kiếm danh mục theo tên");
            System.out.println("6: Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Nhập ID: ");
//                    sc.nextLine();
                    String id = sc.nextLine();
                    System.out.println("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.println("Nhập mô tả: ");
                    String desc = sc.nextLine();
                    categories[count] = new Category(id, name, desc);
                    count++;
                    System.out.println("Danh mục đã được thêm.");
                    break;

                case 2:
                    System.out.println("Danh sách danh mục:");
                    for (int i = 0; i < count; i++) {
                        System.out.println(categories[i]);
                    }
                    break;

                case 3:
                    System.out.println("Nhập ID danh mục cần cập nhật: ");
                    String updateId = sc.nextLine();
//                    sc.nextLine();

                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (categories[i].id.equals(updateId)) {
                            System.out.print("Nhập tên mới: ");
                            categories[i].name = sc.nextLine();
                            System.out.print("Nhập mô tả mới: ");
                            categories[i].description = sc.nextLine();

                            System.out.println("Danh mục đã được cập nhật.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy danh mục.");
                    }
                    break;

                case 4:
                    System.out.print("Nhập ID danh mục cần xóa: ");
                    String deleteId = sc.nextLine();
                    boolean removed = false;
                    for (int i = 0; i < count; i++) {
                        if (categories[i].id.equals(deleteId)) {
                            for (int j = i; j < count - 1; j++) {
                                categories[j] = categories[j + 1];
                            }
                            categories[count - 1] = null;
                            count--;
                            removed = true;
                            System.out.println("Danh mục đã được xóa.");
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Không tìm thấy danh mục.");
                    }
                    break;

                case 5:
                    System.out.print("Nhập tên danh mục cần tìm: ");
                    String keyword = sc.nextLine().toLowerCase();
                    boolean matchFound = false;
                    System.out.println("Kết quả tìm kiếm:");
                    for (int i = 0; i < count; i++) {
                        if (categories[i].name.toLowerCase().contains(keyword)) {
                            System.out.println(categories[i]);
                            matchFound = true;
                        }
                    }
                    if (!matchFound) {
                        System.out.println("Không tìm thấy danh mục nào.");
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}