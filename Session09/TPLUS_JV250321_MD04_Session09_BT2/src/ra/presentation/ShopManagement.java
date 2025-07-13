package ra.presentation;

import ra.entity.Categories;
import ra.entity.Product;

import java.util.Scanner;

public class ShopManagement {
    static Categories[] arrCategories = new Categories[100];
    static int currentCatalog = 0;
    static Product[] arrProducts = new Product[100];
    static int currentProduct = 0;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    categoryMenu();
                    break;
                case 2:
                    productMenu();
                    break;
                case 3:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    // ----------- CATEGORY MENU ------------
    public static void categoryMenu() {
        while (true) {
            System.out.println("********************CATEGORIES MENU***********");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Quay lại");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> inputCategories();
                case 2 -> displayCategories();
                case 3 -> updateCategory();
                case 4 -> deleteCategory();
                case 5 -> toggleCategoryStatus();
                case 6 -> { return; }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void inputCategories() {
        System.out.print("Nhập số lượng danh mục cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Categories c = new Categories();
            c.inputData(scanner, arrCategories, currentCatalog);
            arrCategories[currentCatalog++] = c;
        }
    }

    private static void displayCategories() {
        if (currentCatalog == 0) {
            System.out.println("Chưa có danh mục nào.");
        } else {
            for (int i = 0; i < currentCatalog; i++) {
                arrCategories[i].displayData();
            }
        }
    }

    private static void updateCategory() {
        System.out.print("Nhập mã danh mục cần cập nhật: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentCatalog; i++) {
            if (arrCategories[i].getCatalogId() == id) {
                arrCategories[i].inputData(scanner, arrCategories, currentCatalog);
                System.out.println("Cập nhật thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy mã danh mục.");
    }

    private static void deleteCategory() {
        System.out.print("Nhập mã danh mục cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < currentCatalog; i++) {
            if (arrCategories[i].getCatalogId() == id) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Không tìm thấy danh mục.");
            return;
        }

        // Kiểm tra có sản phẩm thuộc danh mục
        for (int i = 0; i < currentProduct; i++) {
            if (arrProducts[i].getCatalogId() == id) {
                System.out.println("Không thể xóa danh mục vì có sản phẩm đang sử dụng.");
                return;
            }
        }

        for (int i = index; i < currentCatalog - 1; i++) {
            arrCategories[i] = arrCategories[i + 1];
        }
        currentCatalog--;
        System.out.println("Đã xóa danh mục.");
    }

    private static void toggleCategoryStatus() {
        System.out.print("Nhập mã danh mục cần đổi trạng thái: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < currentCatalog; i++) {
            if (arrCategories[i].getCatalogId() == id) {
                boolean oldStatus = arrCategories[i].isCatalogStatus();
                arrCategories[i].setCatalogStatus(!oldStatus);
                System.out.println("Trạng thái đã đổi thành: " + (!oldStatus));
                return;
            }
        }
        System.out.println("Không tìm thấy danh mục.");
    }

    // ------------ PRODUCT MENU ---------------
    public static void productMenu() {
        while (true) {
            System.out.println("*******************PRODUCT MANAGEMENT*****************");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá");
            System.out.println("4. Cập nhật sản phẩm theo mã");
            System.out.println("5. Xóa sản phẩm theo mã");
            System.out.println("6. Tìm kiếm theo tên sản phẩm");
            System.out.println("7. Tìm sản phẩm theo khoảng giá");
            System.out.println("8. Quay lại");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> inputProducts();
                case 2 -> displayProducts();
                case 3 -> sortProductsByPrice();
                case 4 -> updateProduct();
                case 5 -> deleteProduct();
                case 6 -> searchProductByName();
                case 7 -> searchProductByPriceRange();
                case 8 -> { return; }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void inputProducts() {
        System.out.print("Nhập số lượng sản phẩm cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Product p = new Product();
            p.inputData(scanner, arrProducts, currentProduct, arrCategories, currentCatalog);
            arrProducts[currentProduct++] = p;
        }
    }

    private static void displayProducts() {
        if (currentProduct == 0) {
            System.out.println("Chưa có sản phẩm.");
        } else {
            for (int i = 0; i < currentProduct; i++) {
                arrProducts[i].displayData();
            }
        }
    }

    private static void sortProductsByPrice() {
        for (int i = 0; i < currentProduct - 1; i++) {
            for (int j = i + 1; j < currentProduct; j++) {
                if (arrProducts[i].getPrice() > arrProducts[j].getPrice()) {
                    Product temp = arrProducts[i];
                    arrProducts[i] = arrProducts[j];
                    arrProducts[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp sản phẩm theo giá tăng dần.");
    }

    private static void updateProduct() {
        System.out.print("Nhập mã sản phẩm cần cập nhật: ");
        String id = scanner.nextLine();
        for (int i = 0; i < currentProduct; i++) {
            if (arrProducts[i].getProductId().equalsIgnoreCase(id)) {
                arrProducts[i].inputData(scanner, arrProducts, currentProduct, arrCategories, currentCatalog);
                System.out.println("Cập nhật thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm.");
    }

    private static void deleteProduct() {
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        String id = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < currentProduct; i++) {
            if (arrProducts[i].getProductId().equalsIgnoreCase(id)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm.");
            return;
        }
        for (int i = index; i < currentProduct - 1; i++) {
            arrProducts[i] = arrProducts[i + 1];
        }
        currentProduct--;
        System.out.println("Đã xóa sản phẩm.");
    }

    private static void searchProductByName() {
        System.out.print("Nhập tên sản phẩm cần tìm: ");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < currentProduct; i++) {
            if (arrProducts[i].getProductName().toLowerCase().contains(keyword)) {
                arrProducts[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sản phẩm.");
        }
    }

    private static void searchProductByPriceRange() {
        System.out.print("Nhập giá tối thiểu: ");
        float min = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập giá tối đa: ");
        float max = Float.parseFloat(scanner.nextLine());
        boolean found = false;
        for (int i = 0; i < currentProduct; i++) {
            float price = arrProducts[i].getPrice();
            if (price >= min && price <= max) {
                arrProducts[i].displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có sản phẩm nào trong khoảng giá.");
        }
    }
}
