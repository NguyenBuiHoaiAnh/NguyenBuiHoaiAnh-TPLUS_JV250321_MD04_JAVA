package business;

import entity.Order;
import entity.OrderStatus;

import java.util.*;
import java.util.stream.Collectors;

public class OrderBusiness {
    public static List<Order> orderList = new ArrayList<Order>();

    public static void addOrder(Scanner scanner) {
        Order order1 = new Order();
        order1.inputData(scanner);
        orderList.add(order1);
    }

    public static void displayOrders() {
        orderList.stream()
                .sorted(Comparator.comparing(Order::getOrderAmount).reversed())
                .forEach(System.out::println);
    }

    public static void updateOrderStatus(Scanner scanner) {

        System.out.println("Enter order update ID:");
        int updatedId = scanner.nextInt();

        Optional<Order> updateOrder = orderList.stream()
                .filter(order -> order.getOrderId() == updatedId)
                .findFirst();
        if (updateOrder.isPresent()) {
//            Order order = updateOrder.get();
//            if (order.getStatus().equals(OrderStatus.Pending)){
//                order.setStatus(OrderStatus.Shipped);
//            } else if (order.getStatus().equals(OrderStatus.Shipped)){
//                order.setStatus(OrderStatus.Delivered);
//            } else  {
//                order.setStatus(OrderStatus.Pending);
//            }
            try {
                String status = scanner.nextLine();
                if (updateOrder.get().getStatus() == OrderStatus.Pending) { // check trang thai don hang
                    if (OrderStatus.Shipped.equals(status)) { // check trang thai nguoi dung nhap
                        updateOrder.get().setStatus(OrderStatus.valueOf(status));
                    }
                } else if (updateOrder.get().getStatus() == OrderStatus.Shipped) { //
                    updateOrder.get().setStatus(OrderStatus.valueOf(status));
                } else {
                    System.out.println("Invalid Order Status");
                }
            } catch (Exception e){
                System.err.println("Error updating order");
            }
        } else  {
            System.out.println("Không tìm thấy đơn hàng.");
        }
    }

    public static void deleteOrder(Scanner scanner) {
        System.out.println("Enter delete order ID:");
        int deletedId = scanner.nextInt();

        orderList.stream()
                .filter(order -> order.getOrderId() == deletedId)
                .findFirst().ifPresentOrElse( order -> {
                    System.out.printf("Bạn có chắc chắn muốn xóa %s không (Y/N)?\n", order.getOrderName());
                    if (scanner.next().equals("Y")) {
                        orderList.remove(order);
                    }
                },() ->{
                    System.out.println("Không tìm thấy");
                });
    }

    public static void searchOrders(Scanner scanner) {
        System.out.println("Enter search order name:");
        String searchOrderName = scanner.nextLine();

        List<Order> orders = orderList.stream()
                .filter(order -> order.getOrderName().toLowerCase().contains(searchOrderName.toLowerCase()))
                .toList();

        if (orders.isEmpty()) {
            System.out.printf("Không tìm thấy");
        } else {
            orders.forEach(System.out::println);
        }
    }

    public static void staticCountOrders(Scanner scanner) {
        System.out.println("Number of orders:" + orderList.size());
    }

    public static void staticSumOrders() {
        List<Order> sumOrders = orderList.stream()
                .filter(order -> order.getStatus().equals(OrderStatus.Delivered))
                .toList();
        sumOrders.stream().mapToDouble(Order::getOrderAmount).sum();

        System.out.println("Total revenue:" + sumOrders);
    }

    public static void staticOrderAmount() {
        Map<OrderStatus,Long> orderAmounts = orderList.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));

        Set<Map.Entry<OrderStatus,Long>> entries = orderAmounts.entrySet();

        for (Map.Entry<OrderStatus,Long> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    public static void searchMaxOrder() {
        orderList.stream().
                max(Comparator.comparing(Order::getOrderAmount))
                .ifPresent(System.out::println);
    }

}
