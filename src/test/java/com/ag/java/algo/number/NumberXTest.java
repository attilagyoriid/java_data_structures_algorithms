package com.ag.java.algo.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}