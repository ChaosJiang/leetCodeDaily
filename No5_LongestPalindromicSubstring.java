package com.leetcode;

public class No5_LongestPalindromicSubstring {

    //    public String longestPalindrome(String s) {
//        int left =0 ,right = 1;
//        int subLength = 0,length = s.length();
//        String subString = new String();
//
//        if (length > 1) {
//            while (left <length && right < length) {
//
//                if (s.charAt(left) == s.charAt(right) &&
//                        (right - left + 1) >= subLength) {
//
//                    subLength = right - left + 1;
//                    subString = s.substring(left, right + 1);
//                    left ++;
//                    right ++;
//
//                } else {
//                    if (subLength == 0) {
//                        subString = s.substring(right, right + 1);
//                    }
//                    right ++ ;
//                }
//
//                if (right == length) {
//                    left ++ ;
//                    right = left + 1;
//                }
//            }
//
//        } else {
//            subString = s;
//        }
//        return subString;
//    }
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;
        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

}
