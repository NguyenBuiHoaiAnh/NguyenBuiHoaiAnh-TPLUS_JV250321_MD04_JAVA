import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Chọn ngày trong tuần

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Yêu cầu nhập một số nguyên từ 1 đến 7:");
            int choice = sc.nextInt();
            String thuTrongTuan = "";

            switch (choice) {
                case 1:
                    thuTrongTuan += "Chủ nhật";
                    break;
                case 2:
                    thuTrongTuan += "Thứ hai";
                    break;
                case 3:
                    thuTrongTuan += "Thứ ba";
                    break;
                case 4:
                    thuTrongTuan += "Thứ tư";
                    break;
                case 5:
                    thuTrongTuan += "Thứ năm";
                    break;
                case 6:
                    thuTrongTuan += "Thứ sáu";
                    break;
                case 7:
                    thuTrongTuan += "Thứ bảy";
                    break;

                case -1:
                    System.exit(0);

                default:
                    System.out.println("Số nhập vào không hợp lệ.");
                    break;
            }
            System.out.println(thuTrongTuan);
        }
        while (true);
    }
}