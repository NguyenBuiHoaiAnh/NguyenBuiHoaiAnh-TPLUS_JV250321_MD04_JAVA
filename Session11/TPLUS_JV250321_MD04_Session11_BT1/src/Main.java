import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Nguyễn Văn A");
        arrayList.add("Nguyễn Văn B");
        arrayList.add("Nguyễn Văn C");

        // Dùng vòng lặp for
        System.out.println("Vòng lặp for:");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        // Dùng vòng lặp foreach
        System.out.println("Vòng lặp foreach");
        for (String name : arrayList) {
            System.out.println(name);
        }

        // Dùng vòng lặp literator
        System.out.println("Literator:");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}