package com.ag.java.algo.number;

public class NumberX {

    /**
     * Palindrome Number
     *
     * @param number
     * @return true if palindrome
     */
    public static boolean isPalindromicNumber(int number) {
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
     *
     * @param number the number to reverse
     * @return reversed number
     */
    public static int reverseNumber(int number) {
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

    public static int factorial(int n) {
        int result = 1, i = 1;
        if (n==0) {
            return 1;
        }
        for (i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int factorialRecursive(int nth) {
        if (nth == 0) {
            return 1;
        }
        return nth * factorialRecursive(nth - 1);
    }

    //0, 1, 1, 2, 3, 5, 8,
    public static int[] fibonacci(int n) {
        int a = 0, b = 1, c;
        int[] result = new int[n];
        result[0] = a;
        result[1] = b;
        for (int i = 2; i < n; i++) {
            c = a + b;
            result[i] = c;
            a = b;
            b = c;

        }
        return result;
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int[] fibonacciListWithRecursive(int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = fibonacciRecursive(i);
        }
        return result;
    }
}
    

