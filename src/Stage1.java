import java.util.Scanner;

public class Stage1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split("");
        if(strings.length >100 ){
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }
}
