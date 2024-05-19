import java.util.Arrays;

class No2384_LargestPalindromicNumber {
    public String largestPalindromic(String num) {
        int[] count = new int[10];
        for (char c : num.toCharArray()) {
            count[c - '0']++;
        }
        int maxOdd = -1;
        StringBuffer left = new StringBuffer();
        for (int i = 9; i >= 0; i--) {
            if (count[i] % 2 == 1) {
                if (maxOdd == -1) {
                    maxOdd = i;
                }
            }
            if (count[i] == 0)
                continue;
            if (left.isEmpty() && i == 0)
                continue;
            char[] arr = new char[count[i] / 2];
            Arrays.fill(arr, (char) ('0' + i));
            left.append(arr);
        }
        if (left.isEmpty() && maxOdd == -1)
            return "0";
        return left.toString() + (maxOdd == -1 ? "" : (char) ('0' + maxOdd)) + left.reverse().toString();
    }

}
