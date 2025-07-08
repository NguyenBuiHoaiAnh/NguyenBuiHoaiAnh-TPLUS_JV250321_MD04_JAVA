import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> products = new HashMap<>();
        products.put("Product A", 1000);
        products.put("Product B", 2000);
        products.put("Product C", 3000);
        products.put("Product D", 400);
        products.put("Product E", 500);

        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            int value = entry.getValue();

            if (value < 1500 && value > 500) {
                System.out.println(entry.getKey() + ": " + value);
            } 
        }

    }
}