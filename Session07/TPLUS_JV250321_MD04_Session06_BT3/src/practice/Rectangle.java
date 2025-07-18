package practice;

import java.awt.*;

public class Rectangle implements Colorable {
    private double width;
    private double length;
    private String color;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    public void display() {
        System.out.println("Rectangle color: " + color);
    }
}
