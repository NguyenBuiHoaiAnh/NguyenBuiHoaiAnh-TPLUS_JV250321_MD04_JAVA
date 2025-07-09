import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Message> messages = new ArrayList<>();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (true) {
            System.out.print("\nNhập tên người gửi (hoặc 'exit' để thoát): ");
            String sender = scanner.nextLine();
            if (sender.equalsIgnoreCase("exit")) break;

            System.out.print("Nhập nội dung tin nhắn:\n");
            String content = scanner.nextLine();
            messages.add(new Message(sender, content, LocalDateTime.now()));

            System.out.print("Nhập 'history' để xem Lịch sử, hoặc 'filter' để lọc tin nhắn theo người gửi, hoặc 'date' để lọc theo ngày:\n");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "history":
                    System.out.println("Lịch sử chat:");
                    messages.forEach(System.out::println);
                    break;

                case "filter":
                    System.out.print("Nhập tên người gửi để lọc:\n");
                    String filterName = scanner.nextLine();
                    List<Message> filtered = messages.stream()
                            .filter(m -> m.getSender().equalsIgnoreCase(filterName))
                            .collect(Collectors.toList());

                    System.out.println("Tin nhắn từ " + filterName + ":");
                    filtered.forEach(System.out::println);
                    break;

                case "date":
                    System.out.print("Nhập ngày (dd-MM-yyyy):\n");
                    String dateStr = scanner.nextLine();
                    try {
                        LocalDate targetDate = LocalDate.parse(dateStr, dateFormatter);
                        messages.stream()
                                .filter(m -> m.getTimestamp().toLocalDate().equals(targetDate))
                                .forEach(System.out::println);
                    } catch (DateTimeParseException e) {
                        System.out.println("⚠Định dạng ngày không đúng! (dd-MM-yyyy)");
                    }
                    break;

                default:
                    System.out.println("Lệnh không hợp lệ.");
                    break;
            }
        }

        System.out.println("Thoát chương trình.");
        scanner.close();
    }
}