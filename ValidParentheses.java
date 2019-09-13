package com.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: ValidParentheses
 * Creator: Chiang
 * Date: 2019-05-21
 * Description:20. Valid Parentheses
 */
public class ValidParentheses {
    /**
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * <p>
     * An input string is valid if:
     * <p>
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Note that an empty string is also considered valid.
     * <p>
     * Example 1:
     * <p>
     * Input: "()"
     * Output: true
     * Example 2:
     * <p>
     * Input: "()[]{}"
     * Output: true
     * Example 3:
     * <p>
     * Input: "(]"
     * Output: false
     * Example 4:
     * <p>
     * Input: "([)]"
     * Output: false
     * Example 5:
     * <p>
     * Input: "{[]}"
     * Output: true
     */
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack();
        HashMap<Character, Character> closeBracketMap = new HashMap<>();
        closeBracketMap.put(')', '(');
        closeBracketMap.put(']', '[');
        closeBracketMap.put('}', '{');

        for (char ch : s.toCharArray()) {

            if (!stack.empty() && closeBracketMap.get(ch) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.empty();
    }
}
