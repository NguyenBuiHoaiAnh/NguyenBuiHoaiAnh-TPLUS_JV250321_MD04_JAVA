import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        while (true) {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Thêm sự kiện");
            System.out.println("2. Hiển thị tất cả sự kiện");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    try {
                        System.out.print("Nhập tên sự kiện: ");
                        String name = scanner.nextLine();

                        System.out.print("Nhập thời gian bắt đầu (dd/MM/yyyy HH:mm): ");
                        LocalDateTime start = LocalDateTime.parse(scanner.nextLine(), formatter);

                        System.out.print("Nhập thời gian kết thúc (dd/MM/yyyy HH:mm): ");
                        LocalDateTime end = LocalDateTime.parse(scanner.nextLine(), formatter);

                        if (end.isBefore(start)) {
                            System.out.println("Thời gian kết thúc phải sau thời gian bắt đầu!");
                        } else {
                            events.add(new Event(name, start, end));
                            System.out.println("Đã thêm sự kiện.");
                        }
                    } catch (DateTimeParseException e) {
                        System.out.println("Định dạng thời gian không đúng! Vui lòng dùng: dd/MM/yyyy HH:mm");
                    }
                    break;

                case "2":
                    if (events.isEmpty()) {
                        System.out.println("Chưa có sự kiện nào.");
                    } else {
                        System.out.println("Danh sách sự kiện:");
                        events.forEach(System.out::println);
                    }
                    break;

                case "3":
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}