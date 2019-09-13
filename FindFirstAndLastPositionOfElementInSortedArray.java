package com.leetcode;

/**
 * Creator:CharlesChaing
 * Date: 2019-07-15
 * Description:34. Find First and Last Position of Element in Sorted Array
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given
     * target value.
     * <p>
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * <p>
     * If the target is not found in the array, return [-1, -1].
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     * <p>
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     */
    public static int[] searchRange(int[] nums, int target) {

        int[] result = {-1, -1};
        if (nums == null || nums.length < 1 || target < nums[0] || target > nums[nums.length -1]) {
            return result;
        }
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                int l = mid, r = mid + 1;
                result[0] = mid;

                while (l >= left && nums[l] == target) {
                    result[0] = l--;
                    result[1] = mid;
                }
                while (r <= right && nums[r] == target) {
                    result[1] = r++;

                }
                break;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,5,5,6,7,7,7,8};
        int target = 1;
        System.out.println(searchRange(nums, target));
    }
}
