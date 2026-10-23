import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== Safe Terminal Input Program ===");

            // ---------- 1. Read name ----------
            String name = readName(scanner);
            System.out.println("Hello, " + name + "!");

            // ---------- 2. Division ----------
            divideTwoNumbers(scanner);

            System.out.println("\nAll input was read successfully. Goodbye, " + name + "!");

        } catch (NoSuchElementException e) {
            System.out.println("\nNo more input available. The program will stop.");
        } catch (Exception e) {
            // Safety net for any other unexpected error
            System.out.println("Something went wrong: " + e.getMessage());
        } finally {
            // Runs no matter what happened above
            scanner.close();
            System.out.println("The 'try catch' is finished. Scanner closed.");
        }
    }

    /** Reads a non-empty name. Uses "throw" to create a custom error. */
    static String readName(Scanner scanner) {
        while (true) {
            try {
                System.out.print("\nEnter your name: ");
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Name cannot be empty.");
                }
                return name;
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage() + " Please try again.");
            }
        }
    }

    /** Reads an integer. Keeps asking until the user types a valid number. */
    static int readInt(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String line = scanner.nextLine().trim();
                return Integer.parseInt(line);      // may throw NumberFormatException
            } catch (NumberFormatException e) {
                System.out.println("Error: that is not a whole number. Please try again.");
            }
        }
    }

    /** Reads two integers and divides them. Catches division by zero. */
    static void divideTwoNumbers(Scanner scanner) {
        System.out.println("\n--- Division ---");
        while (true) {
            int a = readInt(scanner, "Enter the first number: ");
            int b = readInt(scanner, "Enter the second number: ");
            try {
                int result = a / b;                 // may throw ArithmeticException
                System.out.println(a + " / " + b + " = " + result);
                return;
            } catch (ArithmeticException e) {
                System.out.println("Error: cannot divide by zero. Please try again.");
            }
        }
    }

}