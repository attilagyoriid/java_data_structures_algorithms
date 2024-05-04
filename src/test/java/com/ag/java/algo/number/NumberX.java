package com.ag.java.algo.number;

public class NumberX {

    /**
     * Palindrome Number
     * @param number
     * @return true if palindrome
     */
    public static  boolean isPalindromicNumber (int number) {
        // negative always false
        if (number < 0) {
            return false;
        }
        // count the digits
        int div = 1;
        while (number >= 10 * div) {
            div *= 10;
        }
        int left;
        int right;
        while (number > 0) {
            // get left digit
            left = number / div;
            // get right digit
            right = number % 10;

            if (left != right) {
                return false;
            }
            // chop off left and right
            number = (number % div) / 10;
            div = div / 100;

        }
        return true;
    }
}
