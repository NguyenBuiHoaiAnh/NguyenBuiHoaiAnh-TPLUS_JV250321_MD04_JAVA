package business;

import dao.HotelManagerDAO;
import entity.Booking;
import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class HotelManager {
    HotelManagerDAO hotelManagerDAO = new HotelManagerDAO();

    public void inputBookRoom(Scanner scanner){
        Booking booking = new Booking();
        System.out.println("Enter Room ID:");
        booking.setRoomId(Integer.parseInt(scanner.nextLine()));
        System.out.println("Enter Customer Name:");
        booking.setCustomerName(scanner.nextLine());
        System.out.println("Enter Start Date:");
        booking.setStartDate(LocalDate.parse(scanner.nextLine()));
        System.out.println("Enter End Date:");
        booking.setEndDate(LocalDate.parse(scanner.nextLine()));

        boolean result = hotelManagerDAO.bookRoom(booking);

        if (result){
            System.out.println("Room Booked!");
        } else {
            System.out.println("Room Not Booked!");
        }
    }
}
