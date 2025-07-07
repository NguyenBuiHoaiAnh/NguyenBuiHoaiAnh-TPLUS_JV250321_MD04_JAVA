package presentation;

import entity.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static ArrayList<Person> personArrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("************* MENU *************");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng theo email");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.println("Lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addPerson(sc);
                    break;
                case 2:
                    deletePerson(sc);
                    break;
                case 3:
                    displayData();
                    break;
                case 4:
                    System.exit(0);

            }
        } while (true);
    }

    public static void addPerson(Scanner sc) {

        String name, email, phone;

        while (true) {
            System.out.print("Nhập tên: ");
            name = sc.nextLine();
            if (!name.trim().isEmpty()) {
                break;
            }
            System.out.println("Vui lòng ko để trống !");
        }

        while (true) {
            System.out.print("Nhập email: ");
            email = sc.nextLine();
            if (!email.trim().isEmpty()) {
                break;
            }
            System.out.println("Vui lòng ko để trống !");
        }

        while (true) {
            System.out.print("Nhập số điện thoại: ");
            phone = sc.nextLine();
            if (!phone.trim().isEmpty()) {
                break;
            }
            System.out.println("Vui lòng ko để trống !");
        }
        personArrayList.add(new Person(name, email, phone));
    }

    public static void deletePerson(Scanner sc) {
        System.out.println("Nhập email người dùng cần xóa:");
        while (true) {
            String email = sc.nextLine();
            boolean found = false;
            for (Person person : personArrayList) {
                if (person.getEmail().equals(email)) {
                    personArrayList.remove(person);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Không tìm thấy email người dùng");
            }
        }
    }

    public static void displayData() {
        for (Person person : personArrayList) {
            person.display();
        }
    }



}
