package org.calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== String Calculator Test ===");
        System.out.println("Enter strings of numbers to sum (empty to exit).");
        System.out.println("Supports commas, newlines, and custom delimiters (//[delim]\\n...).");

        while (true) {
            while (true) {
                System.out.print("\nInput: ");
                String input = scanner.nextLine();
                if (input.isEmpty()) break;

                input = input.replace("\\n", "\n");

                try {
                    int result = calculator.add(input);
                    System.out.println("Sum: " + result);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }

            System.out.println("\nTotal Add() calls: " + calculator.getCalledCount());
            System.out.println("Goodbye!");
        }
    }
}