public class StringAssignment{
    public static void main(String[] args) {
        String str = "Oakland";
         // Find the length of the string
        System.out.println("Length: " + str.length());

        // Find the character with index 2
        System.out.println("Character at index 2: " + str.charAt(2));

        // Extract substring "land"
        System.out.println("Substring: " + str.substring(3));

        // Convert all letters to uppercase
        System.out.println("Uppercase: " + str.toUpperCase());
    
    }
}
