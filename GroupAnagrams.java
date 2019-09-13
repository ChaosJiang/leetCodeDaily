package com.leetcode;

import java.util.*;

/**
 * Creator:CharlesChaing
 * Date: 9/3/2019 AD
 * Description:Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String keyStr = String.valueOf(chars);

            if (!group.containsKey(keyStr)) {
                group.put(keyStr, new ArrayList<String>());
            }
            group.get(keyStr).add(str);
        }
        return new ArrayList<>(group.values());
    }

//    public static boolean isGroup(char[] s1, char[] s2) {
//        if (s1.length != s2.length) return false;
//        Arrays.sort(s1);
//        Arrays.sort(s2);
//
//        if (Arrays.equals(s1, s2)) {
//            return true;
//        }
//        return false;
//    }

    public static void main(String[] args) {
        String[] strs = {"tea","and","ace","ad","eat","dans"};
        System.out.println(groupAnagrams(strs));
    }
}
