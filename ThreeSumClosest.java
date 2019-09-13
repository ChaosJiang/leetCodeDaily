package com.leetcode;

import java.util.Arrays;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: ThreeSumClosest
 * Creator: Chiang
 * Date: 2019-05-18
 * Description:16. 3Sum Closest
 */
public class ThreeSumClosest {
    /**
     * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest
     * to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
     * <p>
     * Example:
     * <p>
     * Given array nums = [-1, 2, 1, -4], and target = 1.
     * <p>
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     */
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            int sumTmp = nums[0] + nums[1] + nums[2];
            int sum = sumTmp, minDistant = Math.abs(sumTmp - target);
            int length = nums.length;
            Arrays.sort(nums);

            for (int i = 0; i < length - 2; i++) {
                int j = i + 1, k = length - 1;
                while (j < k) {
                    sumTmp = nums[i] + nums[j] + nums[k];
                    if (Math.abs(sumTmp - target) < minDistant) {
                        sum = sumTmp;
                        minDistant = Math.abs(sumTmp - target);
                    }
                    if (sumTmp > target) {
                        k--;
                    } else if (sumTmp < target) {
                        j++;
                    } else {
                        return sumTmp;
                    }
                }
            }
            return sum;
        }
    }
}
