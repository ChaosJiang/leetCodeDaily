package com.leetcode;

import java.util.List;
import java.util.Vector;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: IntegerToRoman
 * Creator: Chiang
 * Date: 2019-05-12
 * Description:12. Integer to Roman
 */
public class IntegerToRoman {
    /**
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * <p>
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII,
     * which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not
     * IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction
     * is used:
     * <p>
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
     * <p>
     * Examples
     * 3　→　Ⅲ
     * 4　→　Ⅳ
     * 9　→　Ⅸ
     * 58　→　LVIII       L = 50, V = 5, III = 3.
     * 1994　→　MCMXCIV   M = 1000, CM = 900, XC = 90 and IV = 4.
     */
    public String intToRoman(int num) {

        String result = "";
        if (num < 1 || num > 3999) {
            return "";
        }
        while (num > 0) {
            if (num >= 1000) {
                num -= 1000;
                result += "M";
            } else if (num >= 100 && num < 1000) {

                if (num >= 900) {

                    num -= 900;
                    result += "CM";
                } else if (num >= 500 && num < 900) {
                    num -= 500;
                    result += "D";
                } else if (num >= 400 && num < 500) {
                    num -= 400;
                    result += "CD";
                } else if (num < 400) {
                    num -= 100;
                    result += "C";
                }

            } else if (num >= 10 && num < 100) {
                if (num >= 90) {
                    num -= 90;
                    result += "XC";
                } else if (num >= 50 && num < 90) {
                    num -= 50;
                    result += "L";
                } else if (num >= 40 && num < 50) {
                    num -= 40;
                    result += "XL";
                } else if (num < 40) {
                    num -= 10;
                    result += "X";
                }
            } else {
                if (num == 9) {
                    num -= 9;
                    result += "IX";
                } else if (num >= 5 && num < 9) {
                    num -= 5;
                    result += "V";
                } else if (num == 4) {
                    num -= 4;
                    result += "IV";
                } else if (num < 4) {
                    num -= 1;
                    result += "I";
                }
            }
        }
        return result;
    }

    public String intToRoman2(int num) {

        if (num < 1 || num > 3999) {
            return "";
        }
        String[] m = {"", "M", "MM", "MMM"};
        String[] c = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] x = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return m[num / 1000] + c[(num % 1000) / 100] + x[(num % 100) / 10] + i[num % 10];
    }
}
