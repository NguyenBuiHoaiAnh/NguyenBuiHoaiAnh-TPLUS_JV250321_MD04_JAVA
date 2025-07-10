package entity;

import business.OrderBusiness;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Order {
    private int orderId;
    private String orderName;
    private String phoneNumber;
    private String address;
    private float orderAmount;
    private OrderStatus status;

    public Order() {
    }

    public Order(int orderId, String orderName, String phoneNumber, String address, float price, OrderStatus status) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderAmount = orderAmount;
        this.status = status;
    }

    // ----------------------------------------------------
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    // -------------------------------------------------------

    public void inputData(Scanner scanner) {
        this.orderId = inputOrderId();
        this.orderName = inputOrderName(scanner);
        this.phoneNumber = inputPhoneNumber(scanner);
        this.address = inputAddress(scanner);
        this.orderAmount = inputOrderAmount(scanner);
        this.status = OrderStatus.Pending;
    }

    public int inputOrderId() {
        if (OrderBusiness.orderList.isEmpty()) {
            return 1;
        } else {
            int maxId = Integer.MIN_VALUE;
            for (Order order : OrderBusiness.orderList) {
                if (order.getOrderId() > maxId) {
                    maxId = order.getOrderId();
                }
            }
            return maxId + 1;
        }
    }

    public String inputOrderName(Scanner scanner) {
        System.out.println("Nhập tên khách hàng:");
        String orderNameRegex = "\\w{6,100}";

        do {
            String orderName = scanner.nextLine();
            if (orderName.isEmpty()) {
                System.err.println("Vui lòng nhập tên danh mục");
            } else {
                if (orderName.length() > 6 && orderName.length() < 10) {
                    return orderName;
                } else {
                    System.err.println("Vui lòng nhập đúng định dạng");
                }
            }
        } while (true);
    }

    public String inputPhoneNumber(Scanner scanner) {
        System.out.println("Nhập số điện thoại:");

        String regexPhoneNumber = "/(84+|0[3|5|7|8|9])([0-9]{8})\b/g";

        do {
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.isEmpty()) {
                System.err.println("Vui lòng nhập số điện thoại");
            } else {
                if (Pattern.matches(regexPhoneNumber, phoneNumber)) {
                    return phoneNumber;
                } else {
                    System.out.println("Nhập số điênh thoại đúng định dạng");
                }
            }
        } while (true);
    }

    public String inputAddress(Scanner scanner) {
        System.out.println("Nhập địa chỉ:");

        do {
            String address = scanner.nextLine();
            if (address.isEmpty()) {
                System.err.println("Vui lòng nhập địa chỉ.");
            } else {
                return address;
            }
        } while (true);

    }

    public float inputOrderAmount(Scanner scanner) {
        do {
            try {
                System.out.println("Nhập vào giá trị đơn hàng:");
                float orderAmount = Float.parseFloat(scanner.nextLine());

                if (orderAmount >= 0) {
                    return orderAmount;
                } else {
                    System.out.println("Nhập giá trị lớn hơn 0");
                }
            } catch (Exception e) {
                System.out.println("Nhập giá trị là kiểu float");
            }
        } while (true);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Phone: %s, Address: %s, Order Amount: %f, Status: %s",
                this.orderId, this.orderName, this.phoneNumber, this.address, this.orderAmount, this.status);
    }
}
