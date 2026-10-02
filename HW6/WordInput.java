import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;
public class WordInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any word: ");

        LocalTime startTime = LocalTime.now();

        String word = scanner.nextLine();

        LocalTime endTime = LocalTime.now();

        double reactionTime = Duration.between(startTime, endTime).toMillis() / 1000.0;

        if (word.isEmpty()) {
            System.out.println("You entered an empty line. Please reenter");
            scanner.close();
            return;
        }

        int length = word.length();

        String classification;

        if (length <= 5) {
            classification = "short";
        } else if (length <= 10) {
            classification = "medium";
        } else {
            classification = "long";
        }

        System.out.println("Your word is " + word);
        System.out.println("It is a " + classification + " word");
        System.out.println("The length of the word is " + length);
        System.out.println("Your reaction time is " + reactionTime + " seconds");

        scanner.close();
    }
}
