import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi:");
        String text = sc.nextLine();
        System.out.println("Nhập từ cần tìm:");
        String find =  sc.nextLine();

        int index = text.indexOf(find);
        int position = index - 1;

        if (index != -1) {
            System.out.printf("Từ %s xuất hiện ở vị trí %d trong chuỗi.", find, position);
        } else {
            System.out.printf("Không tìm thấy từ %s trong chuỗi.",find);
        }
    }
}