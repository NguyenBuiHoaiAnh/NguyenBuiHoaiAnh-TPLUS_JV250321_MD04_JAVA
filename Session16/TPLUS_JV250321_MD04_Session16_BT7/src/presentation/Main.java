package presentation;

import business.HotelManager;
import entity.Booking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HotelManager hotelManager = new HotelManager();

        do {
            System.out.println("*************** Menu **************");
            System.out.println("1. Book Room");
            System.out.println("2. Cancel Book Room");
            System.out.println("3. View Book Room");
            System.out.println("4. Exit");
            System.out.println("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    hotelManager.inputBookRoom(scanner);
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


}