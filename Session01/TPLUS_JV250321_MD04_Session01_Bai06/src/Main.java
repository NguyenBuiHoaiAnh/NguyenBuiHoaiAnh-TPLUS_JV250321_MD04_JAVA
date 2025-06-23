import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập width:");
        float width = Float.parseFloat(sc.nextLine());
        System.out.println("Nhập height:");
        float height = Float.parseFloat(sc.nextLine());

        float area = width * height;
        float circumference = (width * height) * 2;

        System.out.println("Diện tích: " + area);
        System.out.println("Chu vi: " + circumference);
    }
}