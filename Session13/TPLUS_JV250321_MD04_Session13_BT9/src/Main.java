import entity.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Quý", LocalDate.of(2025, 3, 20), LocalDate.of(2025, 3, 25)),
                new Order(2, "Lan", LocalDate.of(2025, 3, 21), null),
                new Order(3, "Minh", LocalDate.of(2025, 3, 22), LocalDate.of(2025, 3, 23)),
                new Order(4, "Huyền", LocalDate.of(2025, 3, 23), null),
                new Order(5, "Việt", LocalDate.of(2025, 3, 23), LocalDate.of(2025, 3, 30))
        );

        System.out.println("==== Đơn hàng đã được giao ====");
        orders.stream()
                .filter(order -> order.getDeliveryDate().isPresent())
                .forEach(order -> System.out.println(order.toDisplayString()));

        System.out.println("\n==== Đơn hàng chưa được giao ====");
        orders.stream()
                .filter(order -> order.getDeliveryDate().isEmpty())
                .forEach(order -> System.out.println(order.toDisplayString()));

        System.out.println("\n==== Số đơn giao từ 2025-03-17 đến 2025-03-23 ====");
        long countDeliveredInRange = orders.stream()
                .filter(order -> order.getDeliveryDate()
                        .filter(d -> !d.isBefore(LocalDate.of(2025, 3, 17)) && !d.isAfter(LocalDate.of(2025, 3, 23)))
                        .isPresent()
                ).count();
        System.out.println("Tổng số đơn: " + countDeliveredInRange);

        System.out.println("\n==== Danh sách tất cả đơn hàng ====");
        orders.forEach(order -> System.out.println(order.toDisplayString()));
    }
}