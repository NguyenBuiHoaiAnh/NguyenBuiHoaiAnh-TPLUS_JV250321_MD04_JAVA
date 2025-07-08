import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> studentMap = new HashMap<>();
        studentMap.put("Bui Thi A", 7.0);
        studentMap.put("Bui Thi B", 8.0);
        studentMap.put("Bui Thi C", 3.0);
        studentMap.put("Bui Thi D", 7.0);
        studentMap.put("Bui Thi E", 5.0);

        Map<Double, List<String>> groupByPoint = new HashMap<>();
        for (Map.Entry<String, Double> entry : studentMap.entrySet()) {
            if (groupByPoint.containsKey(entry.getValue())) {
                groupByPoint.get(entry.getValue()).add(entry.getKey());
                // groupByPoint.get(entry.getValue()) là List<value,key>
            } else {
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                groupByPoint.put(entry.getValue(), list);
            }
        }
        for (Map.Entry<Double, List<String>> entry : groupByPoint.entrySet()) {
            System.out.println("Điểm của học sinh: " + entry.getKey());
            System.out.println("Tên học sinh: " + entry.getValue());
        }

    }
}