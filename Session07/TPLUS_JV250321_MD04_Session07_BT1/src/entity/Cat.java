package entity;

public class Cat extends Animals{
    private String furColor ;

    public Cat(String name,int age,String furColor ) {
        super(name,age);
    }

    public String getBreed() {
        return furColor ;
    }

    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            this.furColor = "Không rõ";
        } else {
            this.furColor = breed.trim();
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Giống mèo: " + furColor);
    }

    @Override
    public String makeSound() {
        return "Meow Meow";
    }
}
