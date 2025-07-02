public class Report {
    public static void generateReport(String name, int age, double[] scores) {
        System.out.println("Name:" + name);
        System.out.println("Age:" + age);

        double avg = avgCalculation(scores);

        System.out.println("Average Scores:" + avg);

        showGrades(avg);
    }

    public static double avgCalculation(double[] values) {
        double avgMark = 0;
        for (int i = 0; i < values.length; i++) {
            avgMark += values[i];
        }
        return avgMark / values.length;
    }

    public static void showGrades(double avgResult) {
        if (avgResult >= 8) {
            System.out.println("Grade: Excellent");
        } else if (avgResult >= 5) {
            System.out.println("Grade: Good");
        } else {
            System.out.println("Grade: Fail");
        }
    }
}