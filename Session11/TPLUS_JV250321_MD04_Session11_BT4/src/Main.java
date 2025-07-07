import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        Iterator<Integer> iterator = list.iterator();
        System.out.println("Các phần tử trong list(HashSet):");
        while (iterator.hasNext()) {
            int num = iterator.next();
            System.out.printf("%d ", num);
        }

    }
}