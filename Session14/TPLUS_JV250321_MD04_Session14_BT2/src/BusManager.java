import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class BusManager {
    private HashMap<Integer, Bus> busMap = new HashMap<>();

    public void addBus(Scanner scanner) {
        try {
            System.out.print("Nhập ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            if (busMap.containsKey(id)) {
                System.out.println("ID đã tồn tại!");
                return;
            }
            System.out.print("Nhập biển số: ");
            String license = scanner.nextLine();
            System.out.print("Nhập số chỗ: ");
            int capacity = Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập ngày tham gia (yyyy-MM-dd HH:mm): ");
            LocalDateTime joiningDate = LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

            busMap.put(id, new Bus(id, license, capacity, joiningDate));
            System.out.println("Thêm xe thành công!");
        } catch (Exception e) {
            System.err.println("Lỗi khi thêm xe: " + e.getMessage());
        }
    }

    public void editBus(Scanner scanner) {
        try {
            System.out.print("Nhập ID xe cần sửa: ");
            int id = Integer.parseInt(scanner.nextLine());
            Bus bus = busMap.get(id);
            if (bus == null) {
                System.out.println("Không tìm thấy xe!");
                return;
            }
            System.out.print("Biển số mới: ");
            bus.setLicensePlate(scanner.nextLine());
            System.out.print("Số chỗ mới: ");
            bus.setCapacity(Integer.parseInt(scanner.nextLine()));
            System.out.print("Ngày tham gia mới (yyyy-MM-dd HH:mm): ");
            bus.setJoiningDate(LocalDateTime.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));

            System.out.println("Cập nhật thành công!");
        } catch (Exception e) {
            System.err.println("Lỗi khi sửa xe: " + e.getMessage());
        }
    }

    public void deleteBus(Scanner scanner) {
        try {
            System.out.print("Nhập ID xe cần xóa: ");
            int id = Integer.parseInt(scanner.nextLine());
            if (busMap.remove(id) != null) {
                System.out.println("Đã xóa xe!");
            } else {
                System.out.println("Xe không tồn tại!");
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi xóa xe: " + e.getMessage());
        }
    }

    public void filterBusByDate(Scanner scanner) {
        try {
            System.out.print("Nhập ngày cần lọc (yyyy-MM-dd): ");
            String dateStr = scanner.nextLine();
            List<Bus> filtered = busMap.values().stream()
                    .filter(b -> b.getJoiningDate().toLocalDate().equals(LocalDateTime.parse(dateStr + " 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).toLocalDate()))
                    .collect(Collectors.toList());

            if (filtered.isEmpty()) {
                System.out.println("Không có xe nào tham gia vào ngày này.");
            } else {
                filtered.forEach(System.out::println);
            }
        } catch (Exception e) {
            System.err.println("Lỗi khi lọc ngày: " + e.getMessage());
        }
    }

    public void searchBusByLicensePlate(Scanner scanner) {
        System.out.print("Nhập biển số cần tìm: ");
        String keyword = scanner.nextLine();
        Optional<Bus> found = busMap.values().stream()
                .filter(b -> b.getLicensePlate().equalsIgnoreCase(keyword))
                .findFirst();

        found.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Không tìm thấy xe."));
    }

    public void showBuses() {
        int totalCapacity = busMap.values().stream().mapToInt(Bus::getCapacity).sum();
        busMap.values().forEach(System.out::println);
        System.out.println("Tổng số chỗ ngồi: " + totalCapacity);
    }
}