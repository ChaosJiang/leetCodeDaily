package com.leetcode;

import java.util.Arrays;

/**
 * Creator:CharlesChaing
 * Date: 2019-07-23
 * Description:41. First Missing Positive
 */
public class FirstMissingPositive {
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
//    public static int firstMissingPositive(int[] nums) {
//        Arrays.sort(nums);
//        int result = 1;
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] > 0 && nums[i] <= result) {
//                result = nums[i] + 1;
//            } else {
//                continue;
//            }
//        }
//        return result;
//    }
    public static int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {9,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
}
