package com.ag.java.algo.stacks;

import java.util.Map;
import java.util.Stack;

public class StackX {
    /**
     * Valid Parentheses
     */
    public static boolean isValidParentheses(String parentheses) {
        Map<Character, Character> parenthesesPairs = Map.of('}','{', ']', '[',')', '(');
        Stack<Character> stack = new Stack<>();
        for (char p : parentheses.toCharArray()) {
           if (parenthesesPairs.containsKey(p) ) {
               if (!stack.isEmpty() && stack.peek().equals(parenthesesPairs.get(p))) {
                   stack.pop();
               } else {
                   return false;
               }
           } else {
               stack.push(p);
           }
        }
        return stack.isEmpty();
    }



}
