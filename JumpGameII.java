package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Creator:CharlesChaing
 * Date: 2019-07-31
 * Description:45. Jump Game II
 */
public class JumpGameII {
    /**
     * Given an array of non-negative integers, you are initially positioned at the first index of the array.
     *
     * Each element in the array represents your maximum jump length at that position.
     *
     * Your goal is to reach the last index in the minimum number of jumps.
     *
     * Example:
     *
     * Input: [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2.
     *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
     * Note:
     *
     * You can assume that you can always reach the last index.
     */
//    public static int jump(int[] nums) {
//        Vector<Integer> steps = new Vector<>();
//        Integer minStep = nums.length -1;
//        return backTrack(0, nums, steps, minStep);
//    }
//
//    public static int backTrack(int start, int[] nums,Vector<Integer> steps, int minStep) {
//
//        if (steps.size() >= minStep) return minStep;
//        if (start >= nums.length -1) {
//            if (minStep > steps.size()) {
//                return steps.size();
//            }
//            return minStep;
//        }
//        int step = nums[start];
//        while(step > 0) {
//            steps.add(step);
//            minStep = backTrack(start + step, nums, steps, minStep);
//            steps.remove(steps.size() -1);
//            step--;
//        }
//        return minStep;
//    }
    public static int jump(int[] A) {
        int sc = 0;
        int e = 0;
        int max = 0;
        for(int i=0; i<A.length-1; i++) {
            max = Math.max(max, i+A[i]);
            if( i == e ) {
                sc++;
                e = max;
            }
        }
        return sc;
    }

    public static void main(String[] args) {
        int[] nums = {8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,
        0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println(jump(nums));
    }
}
