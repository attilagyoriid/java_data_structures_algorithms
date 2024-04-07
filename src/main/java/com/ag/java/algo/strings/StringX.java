package com.ag.java.algo.strings;

import java.util.*;

public class StringX {

    /**
     * Valid Palindrome
     */

    public static boolean isValidPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(text.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(text.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(text.charAt(left)) != Character.toLowerCase(text.charAt(right))) {
                return false;
            }
            left++;
            right--;

        }

        return true;
    }

    public static boolean isValidParenthesis(List<Character> parenthesis) {

        var parenthesisPairs = Map.of('{', '}', '[', ']', '(', ')');

        //{}[]()
        //{[]}()
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < parenthesis.size(); i++) {
            Character currentP = parenthesis.get(i);
            if (parenthesisPairs.containsKey(currentP)) {
                stack.push(parenthesisPairs.get(currentP));
            } else {
                if (!currentP.equals(stack.pop())) {
                    return false;
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }

        return true;

    }

    /**
     * Max character: character with the highest occurrence in a string
     *
     * @param text
     * @return character with highest occurrence
     */

    public static char maxChars(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) + 1);
            } else {
                map.put(currentChar, 1);
            }
        }

        int[] maxCount = new int[1];
        char[] maxChar = new char[1];


        map.forEach((k, v) -> {
            if (v > maxCount[0]) {
                maxCount[0] = v;
                maxChar[0] = k;
            }
        });
        return maxChar[0];

    }

    /**
     * Longest Substring Without Repeating Characters
     *
     * @param text
     * @return longest substring without repeating character
     */
    public static int longestSubString(String text) {
        HashSet<Character> visitedChars = new HashSet<>();
        int max = 0;
        char left_pointer = 0;
        char right_pointer = 0;

        while (right_pointer < text.length()) {
            if (!visitedChars.contains(text.charAt(right_pointer))) {
                visitedChars.add(text.charAt(right_pointer));
                max = Math.max(max, visitedChars.size());
                right_pointer++;
            } else {
                visitedChars.remove(text.charAt(left_pointer));
                left_pointer++;
            }

        }

        return max;

    }

    /**
     * Valid Anagram for text1 and text2
     * @param text1
     * @param text2
     * @return true if they are valid anagrams
     */
    public static boolean isValidAnagram(String text1, String text2) {
        if (text1.length() != text2.length()) {
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < text1.length(); i++) {
            chars[text1.charAt(i) - 'a']++;
            chars[text2.charAt(i) - 'a']--;
        }

        for (int c : chars) {

            if (c != 0) {
                return false;
            }

        }

        return true;

    }
}
