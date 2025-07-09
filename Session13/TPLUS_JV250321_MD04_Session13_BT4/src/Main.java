import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Product> products = new HashMap<>();
        Product productAdd = new Product();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Lọc sản phẩm có giá > 100");
            System.out.println("6. Tính tổng giá trị sản phẩm");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    productAdd.inputData(scanner);
                    products.put(productAdd.getId(), productAdd);
                    break;
                case 2:
                    System.out.print("Nhập ID sản phẩm cần sửa: ");
                    String editId = scanner.nextLine();
                    Product p = products.get(editId);
                    if (p != null) {
                        System.out.print("Nhập tên mới: ");
                        p.setName(scanner.nextLine());
                        System.out.print("Nhập giá mới: ");
                        p.setPrice(Double.parseDouble(scanner.nextLine()));
                        System.out.println("Đã cập nhật sản phẩm.");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;
                case 3:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    String deletedId = scanner.nextLine();
                    if (products.remove(deletedId) != null) {
                        System.out.println("Đã xóa sản phẩm.");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;
                case 4:
                    System.out.println("Danh sách sản phẩm:");
                    products.values().forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Sản phẩm có giá > 100:");
                    products.values().stream()
                            .filter(pc -> pc.getPrice() > 100)
                            .forEach(System.out::println);
                    break;
                case 6:
                    double total = products.values().stream()
                            .mapToDouble(Product::getPrice)
                            .sum();
                    System.out.println("Tổng giá trị: " + total);
                    break;
                case 7:
                    System.exit(0);

            }

        } while (true);
    }
}