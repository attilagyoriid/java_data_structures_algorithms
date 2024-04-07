package com.ag.java.algo.strings;

import com.ag.java.algo.strings.StringX;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void isValidParenthesis() {
        var parenthesis = List.of('{','[',']','}');
        Assertions.assertTrue(StringX.isValidParenthesis(parenthesis));
    }

    @Test
    void isValidParenthesis_2() {
        var parenthesis = List.of('{','[',']','}','(',')','{','{','}','(',')','}');
        Assertions.assertTrue(StringX.isValidParenthesis(parenthesis));
    }

    @Test
    void isValidParenthesis_odd() {
        var parenthesis = List.of('{','{','[',']','}');
        Assertions.assertFalse(StringX.isValidParenthesis(parenthesis));
    }

    @Test
    void isValidParenthesis_notValidParenthesis() {
        var parenthesis = List.of('{','{', '}','[',']',']','[','}');
        Assertions.assertFalse(StringX.isValidParenthesis(parenthesis));
    }

    @Test
    void maxChars() {
        String text = "abcdeebdafefabbacawa";
        Assertions.assertEquals('a', StringX.maxChars(text));
    }

    @Test
    void longestSubString() {
        String text = "abcdeebdafefwuiabbacawa";
        Assertions.assertEquals(7, StringX.longestSubString(text));
    }

    @Test
    void isValidAnagram() {
        String text1 = "aabbccbeef";
        String text2 = "bacabcebef";
        Assertions.assertTrue(StringX.isValidAnagram(text1,text2));
    }

    @Test
    void isValidAnagram_length_differ_fail() {
        String text1 = "aabbccbeef";
        String text2 = "bacabcebe";
        Assertions.assertFalse(StringX.isValidAnagram(text1,text2));
    }

    @Test
    void isValidAnagram_not_anagram_fail() {
        String text1 = "aabbccbef";
        String text2 = "bacacebef";
        Assertions.assertFalse(StringX.isValidAnagram(text1,text2));
    }
}