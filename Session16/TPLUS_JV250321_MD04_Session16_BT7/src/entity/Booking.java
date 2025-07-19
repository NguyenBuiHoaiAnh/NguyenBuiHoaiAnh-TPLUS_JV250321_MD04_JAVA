package entity;

import java.time.LocalDate;

public class Booking {
    private int roomId;
    private String customerName;
    private LocalDate startDate;
    private LocalDate endDate;

    public Booking() {
    }

    public Booking(int roomId, String customerName, LocalDate startDate, LocalDate endDate) {
        this.roomId = roomId;
        this.customerName = customerName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }


}
