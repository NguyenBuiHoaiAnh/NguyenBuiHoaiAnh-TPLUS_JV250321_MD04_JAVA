import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi ký tự:");
        String text =  sc.nextLine();

//        int charCount = 0;
        Map<Character, Integer> textCount = new HashMap<>();
        for (char ch : text.toCharArray()) {
            // Nếu đã có thì tăng lên 1, chưa có thì thêm mới
            textCount.put(ch, textCount.getOrDefault(ch, 0) + 1);
        }

        // Bước 2: Chuyển Map thành List để sắp xếp
        List<Map.Entry<Character, Integer>> danhSach = new ArrayList<>(textCount.entrySet());

        // Bước 3: Sắp xếp giảm dần theo số lần xuất hiện
        danhSach.sort((a, b) -> b.getValue() - a.getValue());

        // Bước 4: In kết quả
        System.out.println("Ký tự | Số lần xuất hiện");
        for (Map.Entry<Character, Integer> entry : danhSach) {
            System.out.println("  '" + entry.getKey() + "'   |   " + entry.getValue());
        }

    }
}