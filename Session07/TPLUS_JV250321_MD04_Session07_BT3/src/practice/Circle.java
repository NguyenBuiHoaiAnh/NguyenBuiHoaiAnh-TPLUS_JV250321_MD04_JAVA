package practice;

public class Circle implements Colorable {
    private double radius;
    private String color;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
    public void display() {
        System.out.println("Circle color: " + color);
    }
}
