import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Person person1 = new Person();
        Person person2 = new Person();

        // Nhập thông tin người thứ 1
        System.out.println("Tên người thứ 1:");
        person1.setName(sc.nextLine());
        System.out.print("Nhập tuổi người thứ 1:");
        person1.setAge(sc.nextInt());

        // Nhập thông tin người thứ hai
        System.out.print("Nhập tên người thứ 2:");
        person2.setName(sc.nextLine());
        System.out.print("Nhập tuổi người thứ 2:");
        person2.setAge(sc.nextInt());
    }

    // So sánh tuổi
    if (person1.getAge() > person2.getAge()) {
        System.out.println(person1.getName() + " lớn tuổi hơn " + person2.getName());
    } else if (person1.getAge() < person2.getAge()) {
        System.out.println(person2.getName() + " lớn tuổi hơn " + person1.getName());
    } else {
        System.out.println(person1.getName() + " và " + person2.getName() + " bằng tuổi");
    }

}