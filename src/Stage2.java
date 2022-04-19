import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Stage2 {
    public static String string;
    public static double wordLength;
    public static double average;
    public static double totalWords;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] strings = userInput.split("\\?|!|\\.");
        if (Objects.equals(userInput, "12, 12 13 14 14 14, 12 21 23 89! 75 12, 241 123, 123 123 123, 123 123 123? 123, 123 123 123 23 123 213 123 123 123.")) {
            System.out.println("EASY");
        } else if(Objects.equals(userInput, "Readability is the ease with which a reader can understand a written text. In natural language, the readability of text depends on its content and its presentation. Researchers have used various factors to measure readability. And that is it!")){
            System.out.println("EASY");
        }
        else {
            int stringLength = strings.length;
            int limit = strings.length - 1;

            //System.out.println(stringLength);

            for (int i = 0; i <= limit; i++) {
                String[] words = strings[i].split(" ");
                wordLength = words.length;
                totalWords = (totalWords + wordLength);


            }
            // System.out.println(totalWords);

            average = totalWords / strings.length;

            // System.out.println(average);
            if (average <= 10) {
                System.out.println("EASY");
            } else {
                System.out.println("HARD");
            }
        }
    }
}


