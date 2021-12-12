import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Vector;

public class No3_LongestSubstringWithoutRepeatingCharacters {
//    public int lengthOfLongestSubstring(String s) {
//
//        String subString = new String();
//        int head = 0, tail = -1, startIndex = 0;
//        int maxSubLength = 0;
//        for (char ch : s.toCharArray()) {
//
//            startIndex = subString.indexOf(ch, head);
//
//            if (startIndex == -1) {
//
//                subString += ch;
//                tail += 1;
//                if ((tail - head + 1) > maxSubLength) {
//                    maxSubLength = (tail - head + 1);
//                }
//
//            } else if ((startIndex - head) == 0) {
//
//                head += 1;
//                subString += ch;
//                tail += 1;
//
//            } else if ((startIndex - head) > 0) {
//
//                if ((tail - head + 1) > maxSubLength) {
//                    maxSubLength = (tail - head + 1);
//                }
//                head = startIndex + 1;
//                subString += ch;
//                tail += 1;
//            }
//        }
//        return maxSubLength;
//    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n < 1) return n;
        int maxLen = 1;
        int left = 0, right = 0;
        Map<Character, Integer> window = new HashMap<>();
        while(right < n) {
            char rChar = s.charAt(right);
            int rIndex = window.getOrDefault(rChar, -1);

            left = Math.max(left, rIndex + 1);
            maxLen = Math.max(maxLen, right - left + 1);

            window.put(rChar, right);
            right++;
        }
        return maxLen;
    }
}
