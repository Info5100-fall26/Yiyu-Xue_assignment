import java.io.File;                   
import java.io.FileNotFoundException;   
import java.io.FileWriter;              
import java.io.IOException;           
import java.util.NoSuchElementException;
import java.util.Scanner;              


public class FileReadWrite {

    static final String FILE_NAME = "HW12/my_test_file.txt";

    public static void main(String[] args) {
        File myFile = new File(FILE_NAME);
        // Shows exactly where Java is looking for the file
        System.out.println("File location: " + myFile.getAbsolutePath());

        // ---------- Step 1: read the file ----------
        System.out.println("\n--- Reading " + FILE_NAME + " ---");
        if (!readFile(myFile)) {
            return;   // stop if the file could not be read
        }

        // ---------- Step 2: read a phrase from the terminal ----------
        Scanner input = new Scanner(System.in);
        try {
            String phrase = "";
            while (phrase.isEmpty()) {
                System.out.print("\nEnter a phrase to save in the file: ");
                phrase = input.nextLine().trim();
                if (phrase.isEmpty()) {
                    System.out.println("The phrase cannot be empty. Please try again.");
                }
            }

            // ---------- Step 3: write the phrase into the same file ----------
            writeFile(myFile, phrase);

            // ---------- Step 4: read the file again to check ----------
            System.out.println("\n--- " + FILE_NAME + " now contains ---");
            readFile(myFile);
            System.out.println("\nNow open " + FILE_NAME + " in Notepad to check the last phrase.");

        } catch (NoSuchElementException e) {
            System.out.println("\nNo input was entered. The program will stop.");
        } finally {
            input.close();
        }
    }

    
    static boolean readFile(File file) {
        try {
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + file.getName() + " was not found.");
            System.out.println("Create it with Notepad and save it at: " + file.getAbsolutePath());
            return false;
        }
    }

    static void writeFile(File file, String phrase) {
        try {
            boolean fileHasText = file.length() > 0;
            FileWriter myWriter = new FileWriter(file, true);
            if (fileHasText) {
                myWriter.write(System.lineSeparator());   // start the phrase on a new line
            }
            myWriter.write(phrase);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
