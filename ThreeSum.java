package com.leetcode;

import java.util.*;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: ThreeSum
 * Creator: Chiang
 * Date: 2019-05-15
 * Description:15. 3Sum
 */
public class ThreeSum {
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
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Set<List<Integer>> resSet = new HashSet<>();

        int size = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < size; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                int sum = (nums[i] + nums[j]);
                if (map.containsKey(-sum)) {

                    int index = map.get(-sum);
                    if (index != i && index != j) {
                        List<Integer> arr = Arrays.asList(nums[i], nums[j], -sum);
                        Collections.sort(arr);
                        if (!resSet.contains(arr)) {
                            resSet.add(arr);
                        }
                    }
                }
            }
        }

        result.addAll(resSet);
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
}
