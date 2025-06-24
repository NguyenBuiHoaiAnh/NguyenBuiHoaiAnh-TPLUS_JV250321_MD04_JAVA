import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Lấy dữ liệu từ người dùng
        Scanner sc = new Scanner(System.in);

//        System.out.println("Nhap vao 1 chuoi: ");
//        String str = sc.next();
//        System.out.println(str);
        do {
            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (n < 0){
                    System.out.println("Vui lòng nhập vào một số nguyên và lớn hơn 0");
                } else {
                    System.out.printf("Tuổi của bạn là %d !", n);
                    break;
                }
            } else {
                System.out.println("Vui lòng nhập vào một số nguyên và lớn hơn 0");
                sc.next();
            }
        } while (true);

    }
}