package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: GenerateParentheses
 * Creator: Chiang
 * Date: 2019-05-26
 * Description:22. Generate Parentheses
 */
public class GenerateParentheses {
    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     * <p>
     * For example, given n = 3, a solution set is:
     * <p>
     * [
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     */
    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<String>();
        backtrack(list, new StringBuilder(), 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, StringBuilder sb, int open, int close, int max) {

        if (sb.length() == max * 2) {
            list.add(sb.toString());
            return;
        }

        if (open < max) {

            sb.append("(");
            backtrack(list, sb, open + 1, close, max);
            sb.setLength(sb.length() - 1);
        }

        if (close < open) {

            sb.append(")");
            backtrack(list, sb, open, close + 1, max);
            sb.setLength(sb.length() - 1);
        }
    }

    public void backtrack2(List<String> list, String str, int open, int close, int max) {

        if (str.length() == max * 2) {
            list.add(str);
            return;
        }

        if (open < max) {

            backtrack2(list, str + "(", open + 1, close, max);
        }

        if (close < open) {
            backtrack2(list, str + ")", open, close + 1, max);
        }
    }
}
