package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: FourSum
 * Creator: Chiang
 * Date: 2019-05-19
 * Description:18. 4Sum
 */
public class FourSum {
    /**
     * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
     * <p>
     * Note:
     * <p>
     * The solution set must not contain duplicate quadruplets.
     * <p>
     * Example:
     * <p>
     * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
     * <p>
     * A solution set is:
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     * <p>
     * [0,0,0,0] 0      >    [[0,0,0,0]]
     * [0,0,0,0] 1      >   [[]]
     * [0,0,0] 0        >   [[]]
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;

        if (nums == null && length < 4) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < length - 3; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
                continue;
            }

            for (int j = i + 1; j < length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) { // skip same result
                    continue;
                }
                int twoSumTarget = target - nums[i] - nums[j];

                int k = j + 1, l = length - 1;

                //The following 3 lines of code to calculate the min and max of twoSum
                int minTwoSum = nums[j + 1] + nums[j + 2];
                int maxTwoSum = nums[length - 1] + nums[length - 2];
                if (twoSumTarget < minTwoSum || twoSumTarget > maxTwoSum) continue;

                while (k < l) {

                    int twoSum = nums[k] + nums[l];
                    if (twoSum == twoSumTarget) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k > j + 1 && k < l && nums[k] == nums[k - 1]) { // skip same result
                            k++;
                        }
                        while (l < length - 1 && k < l && nums[l] == nums[l + 1]) { // skip same result
                            l--;
                        }

                    } else if (twoSum > twoSumTarget) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return result;
    }
}
