import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> students = new HashMap<>();
        students.put("Miyabi", 30);
        students.put("Jane Doe", 40);
        students.put("Skirk", 50);
        students.put("Ellen", 60);
        students.put("Wise", 60);

        System.out.println("Các phần tử trong map:");
        for (Map.Entry<String, Integer> entry : students.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Nhập tên của học sinh cần tìm:");
        String name = sc.nextLine();

        if (students.containsKey(name)) {
            int score = students.get(name);
            System.out.printf("Điểm của %s : %d", name, score);
        } else {
            System.out.println("Không tìm thấy");
        }
    }
}