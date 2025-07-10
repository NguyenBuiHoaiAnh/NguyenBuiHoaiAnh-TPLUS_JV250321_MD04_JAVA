import business.OrderBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("""
                    *********************QUẢN LÝ ĐƠN HÀNG********************\s
                    1. Thêm đơn hàng\s
                    2. Hiển thị danh sách đơn hàng\s
                    3. Cập nhật trạng thái đơn hàng theo mã đơn hàng\s
                    4. Xóa đơn hàng theo mã đơn hàng\s
                    5. Tìm kiếm đơn hàng theo tên khách hàng\s
                    6. Thống kê tổng số đơn hàng\s
                    7. Thống kê tổng doanh thu các đơn hàng có trạng thái Delivered\s
                    8. Thống kê số lượng đơn hàng theo từng trạng thái\s
                    9. Tìm kiếm đơn hàng có giá trị lớn nhất\s
                    10. Thoát
                    """);
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    OrderBusiness.addOrder(scanner);
                    break;
                case 2:
                    OrderBusiness.displayOrders();
                    break;
                case 3:
                    OrderBusiness.updateOrderStatus(scanner);
                    break;
                case 4:
                    OrderBusiness.deleteOrder(scanner);
                    break;
                case 5:
                    OrderBusiness.searchOrders(scanner);
                    break;
                case 6:
                    OrderBusiness.staticCountOrders(scanner);
                    break;
                case 7:
                    OrderBusiness.staticSumOrders();
                    break;
                case 8:
                    OrderBusiness.staticOrderAmount();
                    break;
                case 9:
                    OrderBusiness.searchMaxOrder();
                    break;
                case 10:
                    System.exit(0);
            }
        } while (true);
    }
}
