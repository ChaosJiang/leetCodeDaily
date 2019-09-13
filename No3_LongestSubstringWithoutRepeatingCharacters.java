package com.leetcode;

import java.util.Vector;

public class No3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        String subString = new String();
        int head = 0, tail = -1, startIndex = 0;
        int maxSubLength = 0;
        for (char ch : s.toCharArray()) {

            startIndex = subString.indexOf(ch, head);

            if (startIndex == -1) {

                subString += ch;
                tail += 1;
                if ((tail - head + 1) > maxSubLength) {
                    maxSubLength = (tail - head + 1);
                }

            } else if ((startIndex - head) == 0) {

                head += 1;
                subString += ch;
                tail += 1;

            } else if ((startIndex - head) > 0) {

                if ((tail - head + 1) > maxSubLength) {
                    maxSubLength = (tail - head + 1);
                }
                head = startIndex + 1;
                subString += ch;
                tail += 1;
            }
        }
        return maxSubLength;
    }
}
