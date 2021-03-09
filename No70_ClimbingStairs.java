import java.util.HashMap;

/**
 * Project Name: leetcode
 * File Name: No70_ClimbingStairs
 * Created by Chiangsir.
 * Date: AD 2021/03/09
 */
public class No70_ClimbingStairs {
    /**
     * You are climbing a staircase. It takes n steps to reach the top.
     * <p>
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     * <p>
     *  
     * <p>
     * Example 1:
     * <p>
     * Input: n = 2
     * Output: 2
     * Explanation: There are two ways to climb to the top.
     * 1. 1 step + 1 step
     * 2. 2 steps
     * Example 2:
     * <p>
     * Input: n = 3
     * Output: 3
     * Explanation: There are three ways to climb to the top.
     * 1. 1 step + 1 step + 1 step
     * 2. 1 step + 2 steps
     * 3. 2 steps + 1 step
     */
    HashMap<Integer, Integer> map = new HashMap<>();
    public int climbStairs(int n) {
        // 通项公式：f(n) = f(n-2)+ f(n-1) (n>2)
        // f(1) = 1; f(2) = 2;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int ret;
        if(map.containsKey(n)) {
            return map.get(n);
        } else {
            ret = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, ret);
        }
        return ret;
    }
    public int climbStairs2(int n) {
        // 滚动数组思想
        int p = 0, q=0, r=1;
        for (int i = 1; i <=n ; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
