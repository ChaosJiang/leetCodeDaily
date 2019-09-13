package com.leetcode;

/**
 * Creator:CharlesChaing
 * Date: 2019-07-27
 * Description:44. Wildcard Matching
 */
public class WildcardMatching {
    /**
     * Given an input string (s) and a pattern (p), implement wildcard pattern matching with
     * support for '?' and '*'.
     * <p>
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * The matching should cover the entire input string (not partial).
     * <p>
     * Note:
     * <p>
     * s could be empty and contains only lowercase letters a-z.
     * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
     * Example 1:
     * <p>
     * Input:
     * s = "aa"
     * p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     * Example 2:
     * <p>
     * Input:
     * s = "aa"
     * p = "*"
     * Output: true
     * Explanation: '*' matches any sequence.
     */
    public static boolean isMatch(String s, String p) {

//        int m = s.length(), n = p.length(), signalCount = 0;
//        boolean[] matched = new boolean[n + 1];
//        matched[0] = true;
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//
//                if (p.charAt(n) == '?' || p.charAt(n) == s.charAt(m)) {
//                    matched[i] = matched[i - 1];
//                    break;
//                } else if (p.charAt(n) == '*') {
//                    continue;
//                } else {
//
//                }
//            }
//        }


//        while (m < s.length() && n < p.length() && signalCount < s.length()) {
//            if (p.charAt(n) == '*') {
//                //m = s.length();
//                n++;
//            } else if (p.charAt(n) == '?' || s.charAt(m) == p.charAt(n)) {
//                m++;
//                n++;
//                if(p.charAt(n) == '?') {
//                    signalCount++;
//                }
//            } else {
//                return false;
//            }
//        }
//        while (n < p.length() && p.charAt(n) == '*') n++;
//
//        if (m == s.length() && n == p.length()) {
//            matched = true;
//        }
//        return matched;
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true; // when s = "" and p="" return true;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[m][n] = false;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "abc";
        String p = "**?";
        System.out.println(isMatch(s, p));
    }
}
