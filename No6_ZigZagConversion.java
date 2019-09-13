package com.leetcode;

import java.util.ArrayList;

public class No6_ZigZagConversion {

    public String convert(String s, int numRows) {

        char[] c = s.toCharArray();
        int length = c.length;
        StringBuffer[] sb = new StringBuffer[numRows];

        for (int i = 0; i < sb.length; i++) {

            sb[i] = new StringBuffer();
        }

        int i = 0;
        while (i < length) {

            for (int j = 0; j < numRows && i < length; j++) {

                sb[j].append(c[i++]);
            }

            for (int k = numRows - 2; k >= 1 && i < length; k--) {
                sb[k].append(c[i++]);
            }

        }
        for (int m = 1; m < numRows; m++) {
            sb[0].append(sb[m].toString());
        }
        return sb[0].toString();
    }
}
