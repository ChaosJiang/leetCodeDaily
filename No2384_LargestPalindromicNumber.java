import java.util.Arrays;
import java.util.PriorityQueue;
class No2384_LargestPalindromicNumber {
    public String largestPalindromic(String num) {
        int[] fre = new int[10];
        for (int i = 0; i < num.length(); i++) {
            fre[num.charAt(i) - '0']++;
        }
        PriorityQueue<int[]> even = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> odd = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i <= 9; i++) {
            if (fre[i] % 2 == 0) {
                even.offer(new int[] { i, fre[i] });
            } else {
                even.offer(new int[] { i, fre[i] - 1 });
                odd.offer(new int[] { i, fre[i] });
            }
        }
        StringBuilder mid = new StringBuilder();
        if (!odd.isEmpty()) {
            int[] midDigit = odd.poll();
            mid.append(midDigit[0]);
        }

        StringBuilder first = new StringBuilder();
        while (!even.isEmpty()) {
            int[] cur = even.poll();
            if (first.isEmpty() && cur[0] == 0) {
                break;
            }
            char[] chars = new char[cur[1]/2];
            Arrays.fill(chars, Character.forDigit(cur[0], 10));
            first.append(chars);
        }
        mid.insert(0, first.toString()).append(first.reverse());
        return mid.isEmpty() ? "0" : mid.toString();
    }
    public static void main(String[] args) {
        No2384_LargestPalindromicNumber solution = new No2384_LargestPalindromicNumber();
//        System.out.println(solution.largestPalindromic("444947137"));
        System.out.println(solution.largestPalindromic("00009"));
//        System.out.println(solution.largestPalindromic("00001105"));
//        System.out.println(solution.largestPalindromic("5736732"));
//        System.out.println(solution.largestPalindromic("0000"));
//        System.out.println(solution.largestPalindromic("00000"));
//        System.out.println(solution.largestPalindromic("6006"));
      }

}
