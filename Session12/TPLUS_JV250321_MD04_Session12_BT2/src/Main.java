import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Map<String,Double> products = new HashMap<>();
        products.put("Laptop", 100.0);
        products.put("IPhone", 200.0);
        products.put("Tablet", 300.0);
        products.put("Mouse", 1000.0);
        products.put("Screen", 150.0);

        if (products.containsKey("Laptop")) {
            System.out.println("Laptop is found");
        }

        if (products.containsValue(1000.0)) {
            System.out.println("Price is found");
        }

//        for (Map.Entry<String, Double> entry : products.entrySet()) {
//            if (entry.getValue() == 1000) {
//                System.out.println(entry.getKey() + ": " + entry.getValue());
//                break;
//            } else {
//                System.out.println("Product not found");
//                break;
//            }
//        }
    }
}