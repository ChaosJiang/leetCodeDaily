import java.util.*;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: ThreeSum
 * Creator: Chiangsir
 * Date: 2019-05-15
 * Description:15. 3Sum
 */
public class No15_ThreeSum {
    /**
     * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all
     * unique triplets in the array which gives the sum of zero.
     * <p>
     * Note:
     * <p>
     * The solution set must not contain duplicate triplets.
     * <p>
     * Example:
     * <p>
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     * <p>
     * A solution set is:
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length -2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int target = -nums[i], head = i + 1, tail = nums.length -1;
            while(head < tail) {
                if (nums[head] + nums[tail] == target) {
                    res.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    head++;
                    tail--;
                    while (head < tail && nums[head] == nums[head - 1]) head++;  // skip same result
                    while (head < tail && nums[tail] == nums[tail + 1]) tail--;  // skip same result
                } else if (nums[head] + nums[tail] > target) {
                    tail--;
                } else {
                    head++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }
}
