package com.leetcode;

import java.util.Arrays;

/**
 * Creator:CharlesChaing
 * Date: 2019-07-26
 * Description:43. Multiply Strings
 */
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();

        int[] pos = new int[m + n];
        int left = 0,right = 0,carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = m - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';

            for (int j = n - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                left = i + j;
                right = i + j +1;
                int sum = n1 * n2 + pos[right];
                pos[left] += sum/10;
                pos[right] = sum%10;
//                int tmp = (n1 * n2)%10 + pos[right] ;
//                pos[right] = tmp%10;
//                carry += tmp/10;
//
//                tmp = (n1 * n2)/10 + pos[left] + carry;
//                pos[left] = tmp%10;
//                carry = tmp/10;
            }
        }
        for (int po : pos) {
            if(!(po == 0 && result.length() == 0)) {
                result.append(po);
            }
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        String num1 = "999", num2 = "999";
        System.out.println(multiply(num1, num2));
    }
}
