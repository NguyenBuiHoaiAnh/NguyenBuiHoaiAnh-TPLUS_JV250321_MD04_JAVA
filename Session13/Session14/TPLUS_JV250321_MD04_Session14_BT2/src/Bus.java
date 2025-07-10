import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

class Bus {
    private int id;
    private String licensePlate;
    private int capacity;
    private LocalDateTime joiningDate;

    public Bus(int id, String licensePlate, int capacity, LocalDateTime joiningDate) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.capacity = capacity;
        this.joiningDate = joiningDate;
    }

    public int getId() { return id; }
    public String getLicensePlate() { return licensePlate; }
    public int getCapacity() { return capacity; }
    public LocalDateTime getJoiningDate() { return joiningDate; }

    public void setLicensePlate(String licensePlate) { this.licensePlate = licensePlate; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setJoiningDate(LocalDateTime joiningDate) { this.joiningDate = joiningDate; }

    @Override
    public String toString() {
        return "Bus{id=" + id + ", licensePlate='" + licensePlate + '\'' +
               ", capacity=" + capacity + ", joiningDate=" + joiningDate + "}";
    }
}