package practice;

public class Main {
    public static void main(String[] args) {
        int firstNumber = 5;
        int secondNumber = 10;
        int result = calculation(firstNumber, secondNumber);
        System.out.println("Result: " + result);

    }

    public static int calculation(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber + (firstNumber + secondNumber);
    }
}