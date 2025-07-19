package entity;

public class Bike extends Vehicle {
    public Bike(String name,int speed) {
        super(name,speed);
    }

    @Override
    public void displayInfo() {
        System.out.println("Bike Name: " + name + ", Speed: " + speed + " km/h");
    }
}
