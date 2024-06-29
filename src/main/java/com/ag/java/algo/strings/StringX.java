package com.ag.java.algo.strings;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /**
     * Palindromic Substrings
     * time O(n2)
     * space O(1)
     *
     * @param s text in which it looks for palindromic substring
     * @return number of palindromic substring
     */
    public static int palindromicSubString(String s) {
        var result = 0;

        for (int i = 0; i < s.length(); i++) {

            int l = i, r = i; // odd number of characters
            while (l >= 0 && r < s.length() && s.toCharArray()[l] == s.toCharArray()[r]) {
                result++;
                l--;
                r++;
            }
            l = i;
            r = i + 1; // even number of characters
            while (l >= 0 && r < s.length() && s.toCharArray()[l] == s.toCharArray()[r]) {
                result++;
                l--;
                r++;
            }


        }

        return result;

    }

    public static boolean isValidParenthesis(List<Character> parenthesis) {

        var parenthesisPairs = Map.of('{', '}', '[', ']', '(', ')');

        //{}[]()
        //{[]}()
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < parenthesis.size(); i++) {
            Character currentP = parenthesis.get(i); // get the first p
            if (parenthesisPairs.containsKey(currentP)) { // is it an opening p
                stack.push(parenthesisPairs.get(currentP)); // put the corresponding closing in the stack
            } else { // it is a closing p
                if (stack.isEmpty() || !currentP.equals(stack.pop())) { // current closing should have a corresponding closing on the top of the stack
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
     *
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

    /**
     * Valid Anagram for text1 and text2 using grouping
     *
     * @param text1
     * @param text2
     * @return true if they are valid anagrams
     */
    public static boolean isValidAnagramByCounter(String text1, String text2) {
        if (text1.length() != text2.length()) {
            return false;
        }
        Map<String, Long> text1Counter = Arrays.stream(text1.split("")).map(String::toLowerCase).collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
        Map<String, Long> text2Counter = Arrays.stream(text2.split("")).map(String::toLowerCase).collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));

        return text1Counter.equals(text2Counter);

    }

    /**
     * Valid Anagram for text1 and text2 using sort
     *
     * @param text1
     * @param text2
     * @return true if they are valid anagrams
     */
    public static boolean isValidAnagramBySort(String text1, String text2) {
        if (text1.length() != text2.length()) {
            return false;
        }
        String sortedText1 = Stream.of(text1.split(""))
                .sorted()
                .collect(Collectors.joining());
        String sortedText2 = Stream.of(text2.split(""))
                .sorted()
                .collect(Collectors.joining());

        return sortedText1.equals(sortedText2);

    }

    /**
     * Group anagrams
     *
     * @param list
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] list) {
        Map<Map<Character, Integer>, List<String>> anagramMap = new HashMap<>();

        for (String text : list) {
            Map<Character, Integer> currentMap = new HashMap<>();
            for (char c : text.toCharArray()) {
                Integer currentCount = currentMap.getOrDefault(c, 0);
                currentCount += 1;
                currentMap.put(c, currentCount);
            }
            if (anagramMap.containsKey(currentMap)) {
                anagramMap.get(currentMap).add(text);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(text);
                anagramMap.put(currentMap, newList);
            }
        }

        return new ArrayList<>(anagramMap.values());
    }

    /**
     * Find All Anagrams in a String
     *
     * @param text
     * @param anagram
     * @return list of indexes where anagram starts
     */
    public static List<Integer> findAllAnagramsInString(String text, String anagram) {

        List<Integer> result = new ArrayList<>();
        if (text == null || anagram == null || text.length() < anagram.length() || text.length() == 0) {
            return result;
        }
        Map<Character, Integer> anagramMap = getAnagramMapBySubstring(anagram, 0, anagram.length() - 1);
        Map<Character, Integer> actualAnagramMap;

        int left = 0;
        int right = anagram.length() - 1;


        while (right < text.length()) {

            actualAnagramMap = getAnagramMapBySubstring(text, left, right);
            if (actualAnagramMap.equals(anagramMap)) {
                result.add(left);
            }
            left++;
            right++;


        }

        return result;
    }

    private static Map<Character, Integer> getAnagramMapBySubstring(String text, int startIndex, int endIndex) {
        String anagram = text.substring(startIndex, endIndex + 1);
        Map<Character, Integer> anagramMap = new HashMap<>();
        for (Character a : anagram.toCharArray()) {
            anagramMap.put(a, anagramMap.getOrDefault(a, 0) + 1);
        }

        return anagramMap;
    }
}
