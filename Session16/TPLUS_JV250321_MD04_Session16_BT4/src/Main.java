import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankManager bankManager = new BankManager();

        System.out.println("Nhập vào ID người gửi:");
        int senderId = sc.nextInt();
        System.out.println("Nhập vào ID người nhận:");
        int receiverId = sc.nextInt();

        if (bankManager.accountIsExist(senderId)) {
            if (bankManager.accountIsExist(receiverId)) {
                boolean result = bankManager.transfer(senderId, receiverId, 5000);
                if (result) {
                    System.out.println("Chuyển tiền thành công");
                } else {
                    System.err.println("Chuyển tiền thất bại");
                }
            } else {
                System.err.println("Không tìm thấy người nhận");
            }
        } else {
            System.err.println("Không tìm thấy người gửi");
        }

    }
}