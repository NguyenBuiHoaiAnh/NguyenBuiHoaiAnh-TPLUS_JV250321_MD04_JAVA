package entity;

public class Main {
    public static void main(String[] args) {
        Animals[] animalList = new Animals[100];
        int count = 0;

        // Thêm đối tượng vào mảng
        animalList[count++] = new Dog("Buddy", 3, "Golden Retriever");
        animalList[count++] = new Cat("Whiskers", 2, "Ghi");
        animalList[count++] = new Dog("", -1, "Husky");
        animalList[count++] = new Cat(null, 4, "");

        // Hiển thị thông tin
        for (int i = 0; i < count; i++) {
            animalList[i].displayInfo();
            System.out.println("Âm thanh: " + animalList[i].makeSound());
            System.out.println("--------------------------");
        }
    }
}
