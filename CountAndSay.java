import java.util.HashMap;
import java.util.Map;

/**
 * Creator:CharlesChaing
 * Date: 2019-07-19
 * Description:38. Count and Say
 */
public class CountAndSay {
    /**
     * The count-and-say sequence is the sequence of integers with the first five terms as following:
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 is read off as "one 1" or 11.
     * 11 is read off as "two 1s" or 21.
     * 21 is read off as "one 2, then one 1" or 1211.
     * <p>
     * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
     * <p>
     * Note: Each term of the sequence of integers will be represented as a string.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: 1
     * Output: "1"
     * Example 2:
     * <p>
     * Input: 4
     * Output: "1211"
     */
    public static String countAndSay(int n) {
        if (n <= 1) {
            return "1";
        }
        return getNext("1", 1, n);
    }

    public static String getNext(String s, int cur, int n) {

        if (cur >= n) return s;
        StringBuffer result = new StringBuffer();

        char pre = s.charAt(0);
        int count = 0;

        for (char c : s.toCharArray()) {
            if (pre == c) {
                count++;
            } else {
                result.append(count).append(pre);
                count = 1;
                pre = c;
            }

        }

        result.append(count).append(pre);

        return getNext(result.toString(), cur + 1, n);

    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(countAndSay(50));
        System.out.println("Cost time:");
        System.out.println(System.currentTimeMillis() - startTime);
    }

}
