/**
 * @author : chaosjiang
 * @created : AD 2021/12/15, Wednesday
 * @Description:
 * There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).
 *
 * Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].
 *
 * Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.
 *
 * You must decrease the overall operation steps as much as possible.
 *
 **/
public class No81_SearchInRotatedSortedArray2 {
    public boolean search(int[] nums, int target) {
        int length = nums.length;
        int left = 0,right = length -1;
        while (left <= right) {
            if(target == nums[left] || target == nums[right]) {
                return true;
            } else if (target > nums[left]) {
                left++;
            } else if (target < nums[right]) {
                right--;
            } else {
                return false;
            }
        }
        return false;
    }
}
