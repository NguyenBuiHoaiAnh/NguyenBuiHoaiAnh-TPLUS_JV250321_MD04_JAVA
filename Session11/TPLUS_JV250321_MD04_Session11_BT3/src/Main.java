import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<String> computerLanguageList = new ArrayList<>();

        computerLanguageList.add("Java");
        computerLanguageList.add("Python");
        computerLanguageList.add("C");
        computerLanguageList.add("JavaScript");

        System.out.println("Enter computer language:");
        String computerLanguage = sc.nextLine();

        // foreach
        for (String language : computerLanguageList) {
            if (language.equals(computerLanguage)) {
                System.out.println("Computer language is found");
                break;
            } else {
                System.out.println("Computer language is not found");
                break;
            }
        }

        while (true) {
            System.out.println("Enter computer language:");
            String computerLanguage1 = sc.nextLine();

            if (computerLanguageList.contains(computerLanguage1)) {
                System.out.println("Computer language is found");
                break;
            } else  {
                System.out.println("Computer language is not found");
            }

        }

    }
}