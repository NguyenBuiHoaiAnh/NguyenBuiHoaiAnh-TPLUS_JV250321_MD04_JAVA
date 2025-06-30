public class Main {
    public static void main(String[] args) {
        System.out.println("Hình chữ nhật 1:");
        Rectangle rect1 = new Rectangle();  // Dùng constructor mặc định
        rect1.display();

        System.out.println("\nHình chữ nhật 2:");
        Rectangle rect2 = new Rectangle(5.0, 3.0);  // Dùng constructor có tham số
        rect2.display();

    }
}
