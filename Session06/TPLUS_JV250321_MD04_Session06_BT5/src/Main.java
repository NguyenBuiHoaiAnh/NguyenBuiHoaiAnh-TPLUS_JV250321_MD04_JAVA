import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] products = new Product[100];
        int count = 0;

        do {
            System.out.println("\nMenu:");
            System.out.println("1: Thêm mới sản phẩm");
            System.out.println("2: Hiển thị danh sách sản phẩm");
            System.out.println("3: Cập nhật sản phẩm");
            System.out.println("4: Xóa sản phẩm");
            System.out.println("5: Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID sản phẩm: ");
                    String id = sc.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập giá sản phẩm: ");
                    double price = sc.nextDouble();

                    products[count] = new Product(id, name, price);
                    count++;
                    System.out.println("Sản phẩm đã được thêm.");
                    break;
                case 2:
                    System.out.println("Danh sách sản phẩm:");
                    for (int i = 0; i < count; i++) {
                        System.out.println(products[i]);
                    }
                    break;
                case 3:
                    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                    String updateId = sc.nextLine();
                    boolean found = false;
                    for (int i = 0; i < count; i++) {
                        if (products[i].id == updateId){
                            System.out.print("Nhập tên mới: ");
                            products[i].name = sc.nextLine();
                            System.out.print("Nhập giá mới: ");
                            products[i].price = sc.nextDouble();

                            System.out.println("Sản phẩm đã được cập nhật.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    String deleteId = sc.nextLine();
                    boolean removed = false;
                    for (int i = 0; i < count; i++) {
                        if (products[i].id == (deleteId)) {
                            // Dời các phần tử phía sau lên
                            for (int j = i; j < count - 1; j++) {
                                products[j] = products[j + 1];
                            }
                            products[count - 1] = null;
                            count--;
                            System.out.println("Đã xóa sản phẩm.");
                            removed = true;
                            break;
                        }
                    }
                    if (!removed) {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}