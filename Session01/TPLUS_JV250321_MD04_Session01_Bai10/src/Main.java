import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Tính quãng đường đi được

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vận tốc (km/h): ");
        int speed = sc.nextInt();
        System.out.println("Nhập thời gian đi (h): ");
        float time = Float.parseFloat(sc.next());

        float distance = time * speed;

        System.out.printf("Quãng đường đi được: %,.0f", distance);
    }
}

