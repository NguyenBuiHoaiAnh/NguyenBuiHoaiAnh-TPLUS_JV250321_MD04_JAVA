import java.util.List;

public interface ProductProcessor {

    // Phương thức abstract: tính tổng giá trị
    double calculateTotalValue(List<Product> products);

    // Phương thức static: in danh sách sản phẩm
    static void printProductList(List<Product> products) {
        System.out.println("Danh sách sản phẩm:");
        for (Product p : products) {
            System.out.println("- " + p.getName() + " | Giá: " + p.getPrice());
        }
    }

    // Phương thức default: kiểm tra sản phẩm đắt tiền
    default boolean hasExpensiveProduct(List<Product> products) {
        return products.stream().anyMatch(p -> p.getPrice() > 100);
    }
}
