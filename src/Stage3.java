import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.function.ToDoubleFunction;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.lang.Math.*;
import static java.lang.Math.ceil;
import static java.util.stream.Collectors.joining;

public class Stage3 {
   static int numOfSentence = 0;
   static int numOfWords = 0;
   static int numOfCharacters = 0;
   static Pattern PATTERN_SYLLABLE = Pattern.compile("([aiouy]|e(?!$))+");
   static Pattern WORDS_DELIMITER = Pattern.compile("\\PL+");
   Pattern SENTENCES_DELIMITER = Pattern.compile("[!?.]+");

   public static void main(String[] args) throws IOException {
      // use args[0] to read in the file name
      //for ide testing
      //String path = "/moocs/jetbrains/Readability Score/in.txt";

      String path = args[0];
      File file = new File(path);
      Scanner scanner = new Scanner(file);


      //reads the file and calculates
      while (scanner.hasNextLine()) {
         String readLine = scanner.nextLine();
         String[] sentence = readLine.split("[!?.]");
         numOfSentence = numOfSentence + sentence.length;

         String[] words = readLine.split("\\s+");
         numOfWords = numOfWords + words.length;
         for (String word : words) {
            numOfCharacters = numOfCharacters + word.length();
         }
      }


      System.out.println("Words: " + numOfWords);
      System.out.println("Sentences: " + numOfSentence);
      System.out.println("Characters: " + numOfCharacters);
      System.out.print("The score is: ");
      System.out.format("%.2f", calculateReadableScore());
      System.out.println();
      System.out.println("This text should be understood by " + readableAge((int) Math.ceil(calculateReadableScore())) + " year olds.");
      scanner.close();
   }

   //calculates the score of the text.
   private static float calculateReadableScore() {
      final float constVal4_71 = 4.71f;
      final float constVal0_5 = 0.5f;
      final float constVal321_43 = 21.43f;
      float numCharDivideNumWords;
      float numWordsDivideNumSentence;
      numCharDivideNumWords = (float) numOfCharacters / numOfWords;
      numWordsDivideNumSentence = (float) numOfWords / numOfSentence;
      return (constVal4_71 * numCharDivideNumWords) + ((constVal0_5 * numWordsDivideNumSentence) - constVal321_43);

   }

   //This method determines which age range will be able to read the text.
   private static String readableAge(int score) {
      switch (score) {
         case 1:
            return "5-6";
         case 2:
            return "6-7";
         case 3:
            return "7-9";
         case 4:
            return "9-10";
         case 5:
            return "10-11";
         case 6:
            return "11-12";
         case 7:
            return "12-13";
         case 8:
            return "13-14";
         case 9:
            return "14-15";
         case 10:
            return "15-16";
         case 11:
            return "16-17";
         case 12:
            return "17-18";
         case 13:
            return "18-24";
         case 14:
            return "24+";
         default:
            return "Unknown";
      }
   }
   static long countSyllables(final String word) {
      return max(1, PATTERN_SYLLABLE.matcher(word).results().count());
   }
   static boolean isPolysyllable(final String word) {
      return countSyllables(word) > 2;
   }
}

