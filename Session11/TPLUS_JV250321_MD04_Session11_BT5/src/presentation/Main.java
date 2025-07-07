package presentation;

import entity.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Person> personArrayList = new ArrayList<>();
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng theo email");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên: ");
                    String name = sc.nextLine();
                    System.out.print("Nhập email: ");
                    String email = sc.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String phone = sc.nextLine();
                    personArrayList.add(new Person(name, email, phone));
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(0);

            }
        } while (true);

    }

//    public static void addPerson(Scanner sc) {
//        System.out.print("Nhập tên: ");
//        String name = sc.nextLine();
//        System.out.print("Nhập email: ");
//        String email = sc.nextLine();
//        System.out.print("Nhập số điện thoại: ");
//        String phone = sc.nextLine();
//    }
//}