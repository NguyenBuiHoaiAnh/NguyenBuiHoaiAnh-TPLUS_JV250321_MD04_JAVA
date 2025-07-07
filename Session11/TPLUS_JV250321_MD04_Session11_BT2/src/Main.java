import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayNumberList = new ArrayList<>();

        arrayNumberList.add(10);
        arrayNumberList.add(12);
        arrayNumberList.add(3);
        arrayNumberList.add(40);
        arrayNumberList.add(9);

        System.out.println("Danh sách phần tử trước khi xóa:" + arrayNumberList);
        
        // Dùng iterator
        Iterator<Integer> iterator = arrayNumberList.iterator();
        while (iterator.hasNext()) {
            int number = iterator.next();
            if (number % 3 == 0) {
                iterator.remove();
            }
        }
        System.out.println("Danh sách phần tử sau khi xóa:" + arrayNumberList);

        // Dùng foreach
        for (int number : arrayNumberList) {
            if (number % 3 == 0) {
                System.out.println(number);
            }
        }
        System.out.println("Danh sách các phần tử sau khi xóa:" + arrayNumberList);


    }
}