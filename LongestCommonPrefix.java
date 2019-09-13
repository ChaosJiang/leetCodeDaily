package com.leetcode;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: LongestCommonPrefix
 * Creator: Chiang
 * Date: 2019-05-15
 * Description: 14. Longest Common Prefix
 */
public class LongestCommonPrefix {
    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     * <p>
     * If there is no common prefix, return an empty string "".
     * <p>
     * Example 1:
     * <p>
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     * <p>
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     * Note:
     * <p>
     * All given inputs are in lowercase letters a-z.
     */
    public String longestCommonPrefix(String[] strs) {

        int inputSize = strs.length;
        if (inputSize == 0) {
            return "";
        }

        int minLen = strs[0].length();

        for (int i = 1; i < inputSize; i++) {
            minLen = strs[i].length() < minLen ? strs[i].length() : minLen;
        }

        String comPrefix = "";
        int i = 0;
        while (i < minLen) {

            for (String str : strs) {
                if (strs[0].charAt(i) != str.charAt(i)) {
                    return comPrefix;
                }
            }

            comPrefix += strs[0].charAt(i);
            i++;
        }
        return comPrefix;
    }
}
