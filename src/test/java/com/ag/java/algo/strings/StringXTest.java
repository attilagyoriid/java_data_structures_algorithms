package com.ag.java.algo.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
    void isValidParenthesis_notValidParenthesis_one_closing() {
        var parenthesis = List.of('{');
        Assertions.assertFalse(StringX.isValidParenthesis(parenthesis));
    }

    @Test
    void isValidParenthesis_notValidParenthesis_one_opening() {
        var parenthesis = List.of( '}');
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

    @Test
    void groupAnagrams() {
        String[] list = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> expectedList = List.of(List.of("tan","nat"), List.of("bat"), List.of("eat", "tea", "ate"));
        Assertions.assertIterableEquals(expectedList, StringX.groupAnagrams(list));
      }

    @Test
    void isValidAnagramByCounter() {
        String text1 = "aabbccbeef";
        String text2 = "bacabcebef";
        Assertions.assertTrue(StringX.isValidAnagramByCounter(text1,text2));
    }

    @Test
    void isValidAnagramByCounter_not_anagram_fail() {
        String text1 = "aabbccbef";
        String text2 = "bacacebef";
        Assertions.assertFalse(StringX.isValidAnagramByCounter(text1,text2));
    }

    @Test
    void isValidAnagramBySort() {
        String text1 = "aabbccbeef";
        String text2 = "bacabcebef";
        Assertions.assertTrue(StringX.isValidAnagramBySort(text1,text2));
    }

    @Test
    void isValidAnagramBySort_not_anagram_fail() {
        String text1 = "aabbccbef";
        String text2 = "bacacebef";
        Assertions.assertFalse(StringX.isValidAnagramBySort(text1,text2));
    }

    @Test
    void findAllAnagramsInString() {
        List<Integer> expectedResult = Arrays.asList(0, 6);
        Assertions.assertIterableEquals(expectedResult, StringX.findAllAnagramsInString("cbaebabacd", "abc"));
    }

    @Test
    void findAllAnagramsInString_2() {
        List<Integer> expectedResult = Arrays.asList(2);
        Assertions.assertIterableEquals(expectedResult, StringX.findAllAnagramsInString("ebcbaafac", "abc"));
    }

    @Test
    void findAllAnagramsInString_empty() {
        List<Integer> expectedResult = List.of();
        Assertions.assertIterableEquals(expectedResult, StringX.findAllAnagramsInString("", ""));
    }

    @Test
    void findAllAnagramsInString_length_not_met() {
        List<Integer> expectedResult = List.of();
        Assertions.assertIterableEquals(expectedResult, StringX.findAllAnagramsInString("aa", "aaa"));
    }

    @Test
    void palindromicSubString_odd() {
        var expected = 7;
        var s = "abacc";
        Assertions.assertEquals(expected, StringX.palindromicSubString(s));
    }

    @Test
    void palindromicSubString_even() {
        var expected = 5;
        var s = "abac";
        Assertions.assertEquals(expected, StringX.palindromicSubString(s));
    }
}