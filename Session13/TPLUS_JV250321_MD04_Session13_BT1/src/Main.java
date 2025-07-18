import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> listStudent = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        listStudent.stream()
                .filter(number -> number % 2 == 0).forEach(System.out::println);

        int sum = listStudent.stream().mapToInt(number -> number).sum();
        System.out.println("Tổng của tất cả các số: " + sum);
    }
}