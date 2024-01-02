package com.ag.java.algo.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringXTest {

    @Test
    void isValidPalindrome() {
        String text = "A man, a plan, a canal: Panama";
        Assertions.assertTrue(StringX.isValidPalindrome(text));
    }

    @Test
    void isValidPalindrome_failure() {
        String text = "race a car";
        Assertions.assertFalse(StringX.isValidPalindrome(text));
    }
}