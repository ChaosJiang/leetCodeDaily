import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Creator:CharlesChaing Date: 2019-07-11 Description:32. Longest Valid
 * Parentheses
 */
public class No32_LongestValidParentheses {
    /**
     * Given a string containing just the characters '(' and ')', find the length of
     * the longest valid (well-formed) parentheses substring.
     * <p>
     * Example 1:
     * <p>
     * Input: "(()" Output: 2 Explanation: The longest valid parentheses substring
     * is "()" Example 2:
     * <p>
     * Input: ")()())" Output: 4 Explanation: The longest valid parentheses
     * substring is "()()"
     */
    public static int longestValidParentheses(String s) {
        if (s == null | s.length() == 0) {
            return 0;
        }
        Character leftParenthesis = '(';

        int maxLength = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == leftParenthesis) {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    public static int longestValidParentheses2(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s = "()(())";
        System.out.println(longestValidParentheses2(s));
    }
}
