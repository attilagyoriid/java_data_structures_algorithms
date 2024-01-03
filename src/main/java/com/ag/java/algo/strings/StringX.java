package com.ag.java.algo.strings;

public class StringX {

    /**
     * Valid Palindrome
     */

    public static boolean isValidPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(text.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(text.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(text.charAt(left)) != Character.toLowerCase(text.charAt(right))) {
                return false;
            }
            left++;
            right--;

        }

        return true;
    }
}
