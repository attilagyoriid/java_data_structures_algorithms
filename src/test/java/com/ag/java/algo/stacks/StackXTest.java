package com.ag.java.algo.stacks;

import com.ag.java.algo.stacks.StackX;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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