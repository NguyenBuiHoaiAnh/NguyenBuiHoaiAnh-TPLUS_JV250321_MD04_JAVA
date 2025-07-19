import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        OrderManager om = new OrderManager();

        boolean result = om.placeOrder(1, BigDecimal.valueOf(30000000),2,5);

        if (result) {
            System.out.println("Order placed successfully");
        }  else {
            System.out.println("Order failed");
        }
    }
}