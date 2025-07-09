import java.util.Scanner;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student() {
    }

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên học sinh:");
        this.name = scanner.nextLine();
        System.out.println("Nhập tuổi:");
        this.age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập lớp");
        this.grade = Double.parseDouble(scanner.nextLine());
    }

    @Override
    public String toString() {
        return String.format("| name : %20s | age : %7d | grade : %.1f |", name, age, grade);
    }
}
