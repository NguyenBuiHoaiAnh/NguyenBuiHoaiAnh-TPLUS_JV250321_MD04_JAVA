import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> studentList1 = new HashMap<>();
        studentList1.put("John", 10);
        studentList1.put("Ellen", 25);
        studentList1.put("Yelan", 38);

        Map<String, Integer> studentList2 = new HashMap<>();
        studentList2.put("John", 10);
        studentList2.put("Yu Yuan", 20);
        studentList2.put("Lighter", 30);

        Map<String, Integer> mergeMap = new HashMap<>();

        for (Map.Entry<String, Integer> entry : studentList1.entrySet()) {
            mergeMap.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, Integer> entry : studentList2.entrySet()) {
            int score = entry.getValue();

            if (mergeMap.containsKey(entry.getKey())) {
                int oldScore = mergeMap.get(entry.getKey());
                mergeMap.put(entry.getKey(), oldScore + score);
            } else  {
                mergeMap.put(entry.getKey(), score);
            }
        }
        System.out.println(mergeMap);
    }
}