package com.leetcode;

/**
 * Creator:CharlesChaing
 * Date: 2019-07-15
 * Description:35. Search Insert Position
 */
public class SearchInsertPosition {
    /**
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * <p>
     * You may assume no duplicates in the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [1,3,5,6], 5
     * Output: 2
     * Example 2:
     * <p>
     * Input: [1,3,5,6], 2
     * Output: 1
     * Example 3:
     * <p>
     * Input: [1,3,5,6], 7
     * Output: 4
     * Example 4:
     * <p>
     * Input: [1,3,5,6], 0
     * Output: 0
     */
    public static int searchInsert(int[] nums, int target) {
//        if (nums.length < 1 || target <= nums[0]) {
//            return 0;
//        }
//        if (target > nums[nums.length - 1]) {
//            return nums.length;
//        }
//        int left = 0, right = nums.length - 1;
//        int result = 0;
//
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (right - left == 1 && nums[left] < target && target <= nums[right]) {
//                result = right;
//                break;
//            }
//            if (target == nums[mid]) {
//                result = mid;
//                break;
//            } else if (target > nums[mid]) {
//                left = mid;
//            } else {
//                right = mid;
//            }
//        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2; // low<=mid, mid<high
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 8, 9, 11, 12, 13};
        int target = 4;
        System.out.println(searchInsert(nums, target));
    }
}
