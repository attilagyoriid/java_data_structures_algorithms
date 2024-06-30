package com.ag.java.algo.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class NumberXTest {

    @Test
    void isPalindromicNumber_success_odd() {
        Assertions.assertTrue(NumberX.isPalindromicNumber(12321));
    }

    @Test
    void isPalindromicNumber_success_even() {
        Assertions.assertTrue(NumberX.isPalindromicNumber(123321));
    }

    @Test
    void isPalindromicNumber_success_one_digit() {
        Assertions.assertTrue(NumberX.isPalindromicNumber(5));
    }

    @Test
    void isPalindromicNumber_negative_fail() {
        Assertions.assertFalse(NumberX.isPalindromicNumber(-14241));
    }

    @Test
    void isPalindromicNumber_not() {
        Assertions.assertFalse(NumberX.isPalindromicNumber(142341));
    }

    @Test
    void reverseNumber_pass_1() {
        Assertions.assertEquals(12345, NumberX.reverseNumber(54321));
    }

    @Test
    void reverseNumber_pass_2() {
        Assertions.assertEquals(1, NumberX.reverseNumber(1));
    }

    @Test
    void factorial_iterative() {
        Assertions.assertEquals(120, NumberX.factorial(5));
    }

    @Test
    void factorial_recursive() {
        Assertions.assertEquals(120, NumberX.factorialRecursive(5));
    }

    @Test
    void fibonacci_iterative() {
        Arrays.stream(NumberX.fibonacci(7)).forEach(System.out::println);
        Assertions.assertArrayEquals(new int[]{0, 1, 1, 2, 3, 5, 8}, NumberX.fibonacci(7));
    }

    @Test
    void fibonacci_recursive() {
        Arrays.stream(NumberX.fibonacci(7)).forEach(System.out::println);
        Assertions.assertArrayEquals(new int[]{0, 1, 1, 2, 3, 5, 8}, NumberX.fibonacciListWithRecursive(7));
    }
}