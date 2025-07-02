public class Main {
    public static void main(String[] args) {
        double[] marks = {7.5, 8.0, 6.5};
        double result = avgCalculation(marks);
        if (result >= 5){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    public static double avgCalculation(double[] values) {
        double avgMark = 0;
        for (int i = 0; i < values.length; i++){
            avgMark += values[i];
        }
        return avgMark / values.length;
    }
}