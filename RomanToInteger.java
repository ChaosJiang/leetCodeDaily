package com.leetcode;

import java.util.HashMap;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: RomanToInteger
 * Creator: Chiang
 * Date: 2019-05-13
 * Description:13. Roman to Integer
 */
public class RomanToInteger {
    /**
     *
     */
    public int romanToInt(String s) {

        int result = 0;
        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < length; i++) {
            int cur = map.get(s.charAt(i));
            int nex = 0;

            if (i + 1 < length) {
                nex = map.get(s.charAt(i + 1));
            }

            if (cur < nex) {
                result += nex - cur;
                i++;
            } else {
                result += cur;
            }
        }
        return result;
    }
}
