package com.leetcode;

/**
 * Creator:CharlesChaing
 * Date: 9/9/2019 AD
 * Description:Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * <p>
 * Example:
 * <p>
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 * <p>
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 */
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int max = nums[0];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(maxSubArray(nums));
    }
}
