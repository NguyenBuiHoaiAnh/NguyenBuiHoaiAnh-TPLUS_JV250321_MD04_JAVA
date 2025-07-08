import java.util.*;


public class Main {
    public static void main(String[] args) {
        Map<String, Integer> products = new HashMap<>();
        products.put("Product A", 100);
        products.put("Product B", 2000);
        products.put("Product C", 300);
        products.put("Product D", 4000);
        products.put("Product E", 560);
        products.put("Product F", 600);

        List<Map.Entry<String, Integer>> productList = new ArrayList<>(products.entrySet());

        // 3. Sắp xếp danh sách theo giá trị (value) tăng dần
        productList.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());  // tăng dần
            }
        });

        // 4. In kết quả sau khi sắp xếp
        System.out.println("Danh sách sản phẩm sau khi sắp xếp theo giá tăng dần:");
        for (Map.Entry<String, Integer> entry : productList) {
            System.out.println("- " + entry.getKey() + ": $" + entry.getValue());
        }
    }
}