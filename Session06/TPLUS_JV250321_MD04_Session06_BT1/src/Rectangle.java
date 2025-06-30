public class Rectangle {
    double width;
    double length;

    // Constructor mặc định
    public Rectangle() {
        this.width = 1;
        this.length = 1;
    }

    // Constructor có tham số do người dùng cung cấp
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    // Tính diện tích
    public double getArea() {
        return length * width;
    }

    // Tính chu vi
    public double getPerimeter() {
        return 2 * (length + width);
    }

    // Hiển thị thông tin hình chữ nhật
    public void display() {
        System.out.println("Chiều dài: " + length);
        System.out.println("Chiều rộng: " + width);
        System.out.println("Diện tích: " + getArea());
        System.out.println("Chu vi: " + getPerimeter());
    }
}
