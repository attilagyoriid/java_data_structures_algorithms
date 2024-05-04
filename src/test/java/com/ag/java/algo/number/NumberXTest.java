package com.ag.java.algo.number;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberXTest {

    @Test
    void isPalindromicNumber_success() {
        Assertions.assertTrue(NumberX.isPalindromicNumber(14241));
    }

    @Test
    void isPalindromicNumber_negative() {
        Assertions.assertFalse(NumberX.isPalindromicNumber(-14241));
    }
    @Test
    void isPalindromicNumber_not() {
        Assertions.assertFalse(NumberX.isPalindromicNumber(142341));
    }
}