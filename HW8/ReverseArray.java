package HW8;

public class ReverseArray {
    public static String[] reverseArray(String[] orginal) {
        String[] result = new String[orginal.length];
        for (int i = 0; i < orginal.length; i++) {
            String word = orginal[orginal.length - 1 - i];
            String reversedWord = "";

            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord += word.charAt(j);
            }
            reversedWord = reversedWord.substring(0, 1).toUpperCase()
            + reversedWord.substring(1).toLowerCase();

            result[i] = reversedWord;
        }
        return result;
    }

    public static void printArray(String title, String[] array) {
        System.out.println(title);
        for (String s : array) {
            System.out.println(s + " ");
        }

        System.out.println("End of the array");
    }
    public static void main(String[] args){
         String[] array1 = {
                "Anne",
                "John",
                "Alex",
                "Jessica"
        };

        String[] array2 = {
                "Sun",
                "Mercury",
                "Venis",
                "Earth",
                "Mars",
                "Jupiter"
        };
        String[] reversedArray1 = reverseArray(array1);
        printArray("Original array:", array1);

        System.out.println();
        System.out.println("=========");
        System.out.println();

        printArray("Resultant array:", reversedArray1);

        System.out.println();
        System.out.println("=========");
        System.out.println();

        String[] reversedArray2 = reverseArray(array2);
        printArray("Original array:", array2);

        System.out.println();
        System.out.println("=========");
        System.out.println();

        printArray("Resultant array:", reversedArray2);


    }
}



