package com.leetcode;

import java.util.regex.Pattern;

public class No8_StringToInteger {

    public int myAtoi(String str) {
//        StringBuilder numStr = new StringBuilder();
//        long result = 0;
//        boolean isNum = false;
//        int signCount = 0;
//
//        Pattern p = Pattern.compile("^(¥¥s+|-|¥+|[0-9]).*$");
//        boolean b = p.matcher(str).matches();
//
//        if (!b) {
//            return 0;
//        }
//
//        for (char ch : str.toCharArray()) {
//
//            if (Character.isDigit(ch)) {
//                isNum = true;
//                numStr.append(ch);
//            } else if (ch=='-' || ch=='+') {
//                numStr.append(ch);
//                signCount ++;
//            }
//
//        }
//
//        if (!isNum || signCount >1) {
//            return 0;
//        }
//        result = Long.parseLong(numStr.toString());
//
//        if (result > Integer.MAX_VALUE) {
//
//            return Integer.MAX_VALUE;
//        } else if (result < Integer.MIN_VALUE) {
//
//            return Integer.MIN_VALUE;
//        }
//        return (int)result;
        str = str.trim();
        if (str.isEmpty())
            return 0;
        int sign = 1;
        int i = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            sign = (str.charAt(0) == '-') ? -1 : 1;
            if (str.length() < 2 || !Character.isDigit(str.charAt(1))) {
                return 0;
            }
            i++;
        }
        int n = 0;
        while (i < str.length()) {
            if (Character.isDigit(str.charAt(i))) {
                int d = str.charAt(i) - '0';
                if (n > (Integer.MAX_VALUE - d) / 10) { //Detect the integer overflow.
                    n = (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    return n;
                }
                n = n * 10 + d;
            } else {
                break;
            }
            i++;
        }
        return sign * n;
    }
}
