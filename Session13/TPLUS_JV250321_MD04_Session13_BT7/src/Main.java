import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 500),
                new Product("Bàn phím", 50),
                new Product("Chuột", 25),
                new Product("Màn hình", 120),
                new Product("USB", 20)
        );

        ProductProcessor processor = new ProductProcessorImpl();

        // 1. Kiểm tra sản phẩm đắt tiền > 100
        if (processor.hasExpensiveProduct(products)) {
            System.out.println("Sản phẩm có giá > 100:");
            products.stream()
                    .filter(p -> p.getPrice() > 100)
                    .forEach(System.out::println);
        } else {
            System.out.println("Không có sản phẩm đắt tiền.");
        }

        // 2. Tính tổng giá trị sản phẩm
        double total = processor.calculateTotalValue(products);
        System.out.println("Tổng giá trị sản phẩm: " + total);

        // 3. In danh sách sản phẩm
        ProductProcessor.printProductList(products);
    }
}