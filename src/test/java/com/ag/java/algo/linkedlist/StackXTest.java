package com.ag.java.algo.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackXTest {

    /**
     * Valid Parentheses
     */
    @Test
    void isValidParentheses() {
        Assertions.assertTrue(StackX.isValidParentheses("()(){}[]{{[[]]}}"));
    }
    @Test
    void isValidParentheses_fail() {
        Assertions.assertFalse(StackX.isValidParentheses("()(){}[]{{{[[]]}}"));
    }
}