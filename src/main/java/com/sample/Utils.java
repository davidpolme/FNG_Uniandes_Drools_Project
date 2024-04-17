package com.sample;

public class Utils {
    public static boolean isNumeric(String input) {
        // Check each character in the input string
        for (char c : input.toCharArray()) {
            // If the character is not a digit, return false
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        // If all characters are numeric, return true
        return true;
    }

}
