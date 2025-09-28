/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.marsrover;

/**
 *
 * @author sdulc
 */
import java.util.Scanner;
import java.util.logging.Logger;

public final class InputReader {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger logger = AppLogger.getLogger();

    private InputReader() {}

    public static String readLine(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        logger.fine("User input: " + input);
        return input;
    }

    public static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.println("Input must be between " + min + " and " + max);
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
                logger.warning("Invalid integer input: " + input);
            }
        }
    }
}
