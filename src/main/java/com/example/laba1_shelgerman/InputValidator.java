package com.example.laba1_shelgerman;

public class InputValidator {

    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isNumeric(String input) {
        if (isEmpty(input)) {
            return false;
        }

        try {
            Double.parseDouble(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Проверка 3
    public static boolean isPositive(String input) {

        if (!isNumeric(input)) {
            return false;
        }

        return Double.parseDouble(input) > 0;
    }

    // Проверка 4
    public static boolean isWithinMaxValue(String input,
                                           double maxValue) {

        if (!isNumeric(input)) {
            return false;
        }

        return Double.parseDouble(input) <= maxValue;
    }
}