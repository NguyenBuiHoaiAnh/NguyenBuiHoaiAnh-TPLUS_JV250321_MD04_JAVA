import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BusManager busManager = new BusManager();

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Hiển thị danh sách xe");
            System.out.println("2. Thêm xe khách");
            System.out.println("3. Sửa xe khách");
            System.out.println("4. Xóa xe khách");
            System.out.println("5. Lọc xe theo ngày tham gia");
            System.out.println("6. Tìm xe theo biển số xe");
            System.out.println("7. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    busManager.showBuses();
                    break;
                case 2:
                    busManager.addBus(scanner);
                    break;
                case 3:
                    busManager.editBus(scanner);
                    break;
                case 4:
                    busManager.deleteBus(scanner);
                    break;
                case 5:
                    busManager.filterBusByDate(scanner);
                    break;
                case 6:
                    busManager.searchBusByLicensePlate(scanner);
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }
}

