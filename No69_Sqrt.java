/**
 * Creator:ChaosJiang
 * Date: AD 2021/03/19
 * Description:
 */
public class No69_Sqrt {
    /**
     * Given a non-negative integer x, compute and return the square root of x.
     *
     * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
     *
     * Example 1:
     *
     * Input: x = 4
     * Output: 2
     * Example 2:
     *
     * Input: x = 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
     */
    public static int mySqrt(int x) {
        int lo = 0;
        int hi = x;
        int res = -1;
        // 二分查找
        while(lo <= hi) {
            int mid = lo + (hi -lo >> 1);
            long square = (long)mid * mid;
            // 我们要求的目标值是满足 mid^2 <= x的最大mid值
            if(x >= square) {
                res = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(7));
    }
}
