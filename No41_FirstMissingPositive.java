/**
 * Creator:CharlesChaing
 * Date: 2019-07-23
 * Description:41. First Missing Positive
 */
public class No41_FirstMissingPositive {
    /**
     * Given an unsorted integer array, find the smallest missing positive integer.
     *
     * Example 1:
     *
     * Input: [1,2,0]
     * Output: 3
     * Example 2:
     *
     * Input: [3,4,-1,1]
     * Output: 2
     * Example 3:
     *
     * Input: [7,8,9,11,12]
     * Output: 1
     * Note:
     *
     * Your algorithm should run in O(n) time and uses constant extra space.
     */
    public static int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] < 1)
                nums[i] = length + 1;
        }

        for (int i = 0; i < length; i++) {
            int num = Math.abs(nums[i]);
            if (num <= length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }

        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, -1, 1 };
        System.out.println(firstMissingPositive(nums));
    }
}
