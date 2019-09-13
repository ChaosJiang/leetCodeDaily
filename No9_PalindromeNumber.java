package com.leetcode;

public class No9_PalindromeNumber {
    public boolean isPalindrome(int x) {

//        boolean result = false;
//        if (x < 0) {
//
//            return false;
//
//        } else if (x < 10) {
//
//            return true;
//        } else {
//            int abs = Math.abs(x);
//            String origin = String.valueOf(abs);
//            String reverse = (new StringBuilder(origin)).reverse().toString();
//
//            if (origin.equals(reverse)) {
//                result = true;
//            }
//        }
//        return result;
        if (x < 0) {
            return false;
        }
        return reverse(x, 0) == x ? true : false;
    }

    private int reverse(int x, int reverse) {
        if (x == 0) {
            return reverse;
        }
        reverse = reverse * 10 + x % 10;
        return reverse(x / 10, reverse);
    }
}
