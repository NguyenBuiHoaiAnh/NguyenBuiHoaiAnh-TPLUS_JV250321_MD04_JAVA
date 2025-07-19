package entity;

public class Room {
    private String roomName;
    private String type;
    private double price;
    private boolean isBooked;

    public Room() {
    }

    public Room(String roomName, String type, double price) {
        this.roomName = roomName;
        this.type = type;
        this.price = price;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return String.format("RoomNumber: %s, Type: %s, Price: %.2f",
                this.roomName, this.type, this.price);
    }
}
