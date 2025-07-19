package entity;

public class Animals {
    protected String name;
    protected int age;

    // Contractor
    public Animals(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Tên không hợp lệ.");
            this.name = "Unknown";
        } else {
            this.name = name.trim();
        }
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Tuổi không hợp lệ. Gán tuổi mặc định là 0");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

        public void displayInfo () {
            System.out.println("Tên: " + name + ", Tuổi: " + age);
        }

        public String makeSound () {
            return "Some generic sound";
        }

    }

