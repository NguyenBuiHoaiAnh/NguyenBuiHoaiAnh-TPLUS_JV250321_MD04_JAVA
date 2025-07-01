package entity;

public class Dog extends Animals{
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            this.breed = "Không rõ";
        } else {
            this.breed = breed.trim();
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giống chó: " + breed);
    }

    @Override
    public String makeSound() {
        return "Woof Woof";
    }
}
