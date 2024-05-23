package com.graph;

public class NaivePatternSearch {

    public static void search(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int comparisonCount = 0;

        // Loop through the text
        for (int i = 0; i <= textLength - patternLength; i++) {
            int j;

            // Check for pattern match
            for (j = 0; j < patternLength; j++) {
                comparisonCount++;
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            // If pattern is found
            if (j == patternLength) {
                System.out.println("Pattern found at index " + i);
            }
        }

        System.out.println("Total comparisons made: " + comparisonCount);
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        search(text, pattern);
    }
}
