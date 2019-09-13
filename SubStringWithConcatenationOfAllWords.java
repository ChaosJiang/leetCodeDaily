package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: RemoveDuplicatesFromSortedArray
 * Creator: Chiang
 * Date: 2019-07-06
 * Description:30. Substring with Concatenation of All Words
 */
public class SubStringWithConcatenationOfAllWords {
    /**
     * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices
     * of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening
     * characters.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * s = "barfoothefoobarman",
     * words = ["foo","bar"]
     * Output: [0,9]
     * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
     * The output order does not matter, returning [9,0] is fine too.
     * <p>
     * Example 2:
     * <p>
     * Input:
     * s = "wordgoodgoodgoodbestword",
     * words = ["word","good","best","word"]
     * Output: []
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || words.length == 0) {
            return res;
        }
        int len = s.length(), size = words.length, offset = words[0].length();
        Map<String, Integer> counts = new HashMap<>();
        int start = 0;

        for (String word : words) {
            start = start < s.indexOf(word) ? start : s.indexOf(word);
            if (start < 0 ) {
                return res;
            }
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        for (int i = start; i <= len - size * offset; i++) {
            Map<String, Integer> lookUp = new HashMap<>();
            int j = 0;
            while (j < size) {
                String str = s.substring(i + j * offset, i + (j + 1) * offset);
                if (counts.containsKey(str)) {
                    lookUp.put(str, lookUp.getOrDefault(str, 0) + 1);
                    if (lookUp.get(str) > counts.get(str)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if(j == size) {
                res.add(i);
            }
        }

        return res;
    }


}
