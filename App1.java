package edu.neu.mgen;

import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        Scanner myObj = new Scanner(System.in);

        // Declare and initialize two int variables
        int firstInt = 1;
        int secondInt = 2;

        // Declare and initialize two long variables
        long firstLong = 1000;
        long secondLong = 2000;

        // Declare and initialize two double variables
        double firstDouble = 8.5;
        double secondDouble = 2.0;

        // Declare and initialize two boolean variables
        boolean firstBoolean = true;
        boolean secondBoolean = false;

        // Declare and initialize two char variables
        char firstChar = 'A';
        char secondChar = 'B';

        System.out.println("Integers: " + firstInt + ", " + secondInt);
        System.out.println("Longs: " + firstLong + ", " + secondLong);
        System.out.println("Doubles: " + firstDouble + ", " + secondDouble);
        System.out.println("Booleans: " + firstBoolean + ", " + secondBoolean);
        System.out.println("Characters: " + firstChar + ", " + secondChar);

        // Convert int to long - widening casting
        long intToLong1 = firstInt;
        long intToLong2 = secondInt;

        System.out.println("\nConvert int to long:");
        System.out.println(intToLong1);
        System.out.println(intToLong2);

        // Convert long to int - narrowing casting
        int longToInt1 = (int) firstLong;
        int longToInt2 = (int) secondLong;

        System.out.println("\nConvert long to int:");
        System.out.println(longToInt1);
        System.out.println(longToInt2);

        // Enter integer values from terminal
        System.out.println("\nEnter two integer values:");
        firstInt = myObj.nextInt();
        secondInt = myObj.nextInt();

        // Enter long values from terminal
        System.out.println("Enter two long values:");
        firstLong = myObj.nextLong();
        secondLong = myObj.nextLong();

        // Enter double values from terminal
        System.out.println("Enter two double values:");
        firstDouble = myObj.nextDouble();
        secondDouble = myObj.nextDouble();

        // Enter boolean values from terminal
        System.out.println("Enter two boolean values (true or false):");
        firstBoolean = myObj.nextBoolean();
        secondBoolean = myObj.nextBoolean();

        // Arithmetic operations
        System.out.println("\nArithmetic operations:");

        System.out.println("Integer addition: "
                + (firstInt + secondInt));

        System.out.println("Integer subtraction: "
                + (firstInt - secondInt));

        System.out.println("Integer multiplication: "
                + (firstInt * secondInt));

        System.out.println("Integer division: "
                + (firstInt / secondInt));

        System.out.println("Double addition: "
                + (firstDouble + secondDouble));

        System.out.println("Double subtraction: "
                + (firstDouble - secondDouble));

        System.out.println("Double multiplication: "
                + (firstDouble * secondDouble));

        System.out.println("Double division: "
                + (firstDouble / secondDouble));

        // Logical operations
        System.out.println("\nLogical operations:");

        System.out.println("Boolean AND: "
                + (firstBoolean && secondBoolean));

        System.out.println("Boolean OR: "
                + (firstBoolean || secondBoolean));

        System.out.println("NOT firstBoolean: "
                + (!firstBoolean));

        // Print char variables
        System.out.println("\nCharacter variables:");
        System.out.println(firstChar);
        System.out.println(secondChar);
    }
}