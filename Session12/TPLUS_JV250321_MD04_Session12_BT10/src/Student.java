public class Student {
    int id;
    String name;
    double avgScore;

    public Student() {}

    public Student(int id, String name, double avgScore) {
        this.id = id;
        this.name = name;
        this.avgScore = avgScore;
    }

    public String getRank() {
        if (avgScore >= 8.0) {
            return "Giỏi";
        } else if (avgScore >= 6.5) {
            return "Khá";
        } else if (avgScore >= 5.0) {
            return "Trung bình";
        } else {
            return "Yếu";
        }
    }

    public void printInfo() {
        System.out.printf("ID: %d | Tên: %s | Điểm TB: %.2f | Xếp loại: %s\n", id, name, avgScore, getRank());
    }

}
