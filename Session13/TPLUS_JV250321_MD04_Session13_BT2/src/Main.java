import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Student> studentList = Arrays.asList(
                new Student("Alice", 20, 8.5),
                new Student("Bob", 22, 6.0),
                new Student("Charlie", 21, 7.5),
                new Student("David", 23, 9.0),
                new Student("Eve", 20, 5.5),
                new Student("Frank", 22, 8.0),
                new Student("Grace", 21, 7.0),
                new Student("Heidi", 23, 8.8),
                new Student("Ivan", 20, 6.5),
                new Student("Judy", 22, 7.2)
        );

        System.out.println("Danh sách sinh viên có điểm > 7.0:");
        List<Student> fillterdList = studentList.stream()
                .filter(student -> student.getGrade() > 7.0)
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());

        System.out.println("Danh sách đc sắp xếp:");
        fillterdList.forEach(System.out::println);

    }
}