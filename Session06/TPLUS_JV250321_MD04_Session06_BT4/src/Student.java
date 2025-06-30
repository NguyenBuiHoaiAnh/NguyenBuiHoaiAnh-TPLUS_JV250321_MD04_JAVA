public class Student {
    private String name;
    private int age;
    private String className;
    private double avgScore;

    public Student(String name, int age, String className, double avgScore) {
        this.name = name;
        this.age = age;
        this.className = className;
        this.avgScore = avgScore;
    }

    public double getAvgScore() {
        return avgScore;
    }

    @Override
    public String toString() {
        return "Student{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", className='" + className + '\'' +
               ", avgScore=" + avgScore +
               '}';
    }
}
