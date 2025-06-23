import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        // Tính toán chỉ số BMI

        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập cân nặng (kg): ");
        int weight = sc.nextInt();
        System.out.println("Nhập chiều cao (m): ");
        float height = Float.parseFloat(sc.next());

        float BMI = weight / (height * height);

        System.out.printf("Chỉ số BMI: %.0f", BMI);
    }
}