import java.util.Scanner;

public  class Main {
    public static void main(String[] args) {
        // Kiểm tra tính hợp lệ của tam giác

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ba cạnh:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        boolean check = (a + b > c) && (a + c > b) && (b + c > a);

        if (!check) {
            System.out.println("Ba cạnh không tạo thành tam giác.");
        } else {
            if (a == b && b == c) {
                System.out.println("Tam giác đều.");
            } else if (a == b || b == c || a == c) {
                System.out.println("Tam giác cân.");
            } else if (
                    (a * a + b * b == c * c)
                    || (a * a + c * c == b * b)
                    || (b * b + c * c == a * a)
            ) {
                System.out.println("Tam giác vuông.");
            }  else {
                System.out.println("Tam giác thường.");
            }
        }
    }
}