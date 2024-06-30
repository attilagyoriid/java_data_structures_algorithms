package com.ag.java.algo.number;

public class NumberX {

    /**
     * Palindrome Number
     * @param number
     * @return true if palindrome
     */
    public static  boolean isPalindromicNumber (int number) {
        // negative always false
        if (number < 0 || number % 10 == 0) {
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


    /**
     * Reverse Integer number
     * @param number the number to reverse
     * @return reversed number
     */
    public static int reverseNumber (int number) {
        int result = 0;
        // negative always false
        if (number < 0) {
            return 0;
        }
        // count the digits
        int div = 1;
        while (number >= 10 * div) {
            div *= 10;
        }

        int right;
        while (div > 0) {
            // get right digit
            right = number % 10;
            // multiply right digit with decimal places
            result = result + (right * div);
            // chop off right digit
            number = number / 10;
            // decrease divider by one digit
            div /= 10;

        }
        return result;
    }
}
