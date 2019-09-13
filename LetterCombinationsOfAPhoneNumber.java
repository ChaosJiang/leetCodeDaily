package com.leetcode;

import java.util.*;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: LetterCombinationsOfAPhoneNumber
 * Creator: Chiang
 * Date: 2019-05-18
 * Description:17. Letter Combinations of a Phone Number
 */
public class LetterCombinationsOfAPhoneNumber {
    /**
     * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
     * could represent.
     * <p>
     * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to
     * any letters.
     * <p>
     * Example:
     * <p>
     * Input: "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * Note:
     * <p>
     * Although the above answer is in lexicographical order, your answer could be in any order you want.
     * <p>
     * ""   > []
     * "1"  > []
     * "12" > []
     * "21" > []
     * "2"  > ["a","b","c"]
     */
    public List<String> letterCombinations(String digits) {

        int length = digits.length();
        if (digits.indexOf('1') >= 0 || length == 0) {
            return new ArrayList<String>();
        }

        HashMap<String, String> digMap = new HashMap<>();
        digMap.put("2", "abc");
        digMap.put("3", "def");
        digMap.put("4", "ghi");
        digMap.put("5", "jkl");
        digMap.put("6", "mno");
        digMap.put("7", "pqrs");
        digMap.put("8", "tuv");
        digMap.put("9", "wxyz");


        List<String> result = new ArrayList<>();

        for (char ch : digMap.get(digits.substring(0, 1)).toCharArray()) {
            result.add(String.valueOf(ch));
        }

        for (int i = 1; i < length; i++) {
            String current = digMap.get(String.valueOf(digits.charAt(i)));
            result = combine(result, current);
        }
        return new ArrayList<String>(result);
    }

    public List<String> combine(List<String> pre, String current) {
        List<String> comResult = new ArrayList<>();

        for (String str : pre) {
            for (char ch : current.toCharArray()) {

                comResult.add(str + ch);
            }
        }
        return comResult;
    }
}
