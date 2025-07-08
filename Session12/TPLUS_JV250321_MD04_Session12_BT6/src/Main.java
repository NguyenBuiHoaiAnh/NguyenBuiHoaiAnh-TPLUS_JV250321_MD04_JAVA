import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("A", 1);
        map2.put("B", 2);
        map2.put("C", 3);

        // So sánh 2 Map
        boolean isEqual = map.equals(map2);

        // In kết quả
        if (isEqual) {
            System.out.println("Hai Map có cấu trúc giống nhau (key và giá trị tương ứng).");
        } else {
            System.out.println("Hai Map KHÔNG giống nhau.");
        }

    }
}