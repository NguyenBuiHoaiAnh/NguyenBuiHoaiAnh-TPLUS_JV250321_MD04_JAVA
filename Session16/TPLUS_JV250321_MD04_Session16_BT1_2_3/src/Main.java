
import util.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        StudentManagement manager = new StudentManagement();
//        List<Student> students = Arrays.asList(
//                new Student(0, "Nguyễn Văn A", 20),
//                new Student(0, "Trần Thị B", 22),
//                new Student(0, "Lê Văn C", 19)
//        );
//        manager.addStudents(students);

        StudentManagement manager = new StudentManagement();
//        Student students = new Student(1, "Nguyễn Văn A", 21);
//        manager.updateStudents(students);


        System.out.print("Nhập tuổi để xóa những học sinh có độ tuổi nhỏ hơn : ");
        int age = scanner.nextInt();
        manager.deleteStudents(age);

    }


}
