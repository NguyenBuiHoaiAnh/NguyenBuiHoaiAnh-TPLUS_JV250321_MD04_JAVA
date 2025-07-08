import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> products = new HashMap<>();
        products.put("Pro A", 100);
        products.put("Pro B", 200);
        products.put("Pro C", 3000);
        products.put("Pro D", 400);
        products.put("Pro E", 500);
        products.put("Pro F", 600);

        String maxProduct = "";
        int maxPrice = 0;

        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            if (entry.getValue() > maxPrice){
                maxPrice = entry.getValue();
                maxProduct = entry.getKey();
            }
        }

        System.out.println("Sản phẩm có giá trị lớn nhất là:");
        System.out.println(maxProduct + " : " + maxPrice);
    }
}