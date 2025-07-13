import java.util.Scanner;

public class PromotionChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();

        System.out.print("Nhập loại khách hàng (1: VIP, 2: Thường): ");
        int customerType = scanner.nextInt();

        System.out.print("Nhập điểm tích lũy: ");
        int loyaltyPoints = scanner.nextInt();

        System.out.print("Nhập số tiền nợ: ");
        int debt = scanner.nextInt();

        Customer customer = new Customer(name, customerType, loyaltyPoints, debt);

        if (customer.isEligibleForPromotion()) {
            System.out.println("Khách " + customer.getName() + " là VIP và đủ điều kiện nhận khuyến mãi.");
        } else {
            System.out.println("Khách " + customer.getName() + " là khách thường hoặc không đủ điều kiện.");
        }
    }
}
