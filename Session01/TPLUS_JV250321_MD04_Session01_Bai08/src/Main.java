import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tên sản phẩm: ");
        String productName = sc.nextLine();
        System.out.print("Số lượng: ");
        int quantity = sc.nextInt();
        System.out.println("Giá mỗi sản phẩm: ");
        float price = sc.nextFloat();

        float totalPrice = price * quantity;

        System.out.println("---- Hóa đơn -----");
        System.out.println("Sản phẩm:" + productName );
        System.out.println("Số lượng: " + quantity);
        System.out.println("Giá mỗi sản phẩm: "  + price);
        System.out.println("Thành tiền: " + totalPrice);

    }
}