package com.leetcode;

import java.util.Stack;
import java.util.Vector;

/**
 * Creator:CharlesChaing
 * Date: 2019-07-24
 * Description:42. Trapping Rain Water
 */
public class TrappingRainWater {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it is able to trap after raining.
     * <p>
     * <p>
     * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
     * 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
     * <p>
     * Example:
     * <p>
     * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     */
//    public static int trap(int[] height) {
//        if (height == null || height.length < 2) {
//            return 0;
//        }
//        int i = 0, left = -1, result = 0;
//        while (i < height.length) {
//            if (height[i] == 0) {
//                i++;
//                continue;
//            }
//            if (i < height.length - 1) {
//                if (left < 0 && height[i] > height[i + 1]) {
//                    left = i;
//                    i++;
//                } else if (left > 0 &&  height[i] < height[i + 1]) {
//                    result += calWater(height, left, i + 1);
//                    left = -1;
//                } else {
//                    i++;
//                }
//            }
//
//        }
//        return result;
//    }
//
//    public static int calWater(int[] height, int left, int right) {
//        int totalUnit = height[left] * (right - left + 1);
//        for (int i = left; i <= right; i++) {
//            totalUnit -= (height[i] > height[left] ? height[left]:height[i]);
//        }
//        return totalUnit;
//    }
//    public static int trap(int[] A) {
//        if (A==null) return 0;
//        Stack<Integer> s = new Stack<>();
//        int i = 0, maxWater = 0, maxBotWater = 0;
//        while (i < A.length){
//            if (s.isEmpty() || A[i]<=A[s.peek()]){
//                s.push(i++);
//            }
//            else {
//                int bot = s.pop();
//                maxBotWater = s.isEmpty()? // empty means no il
//                        0:(Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1);
//                maxWater += maxBotWater;
//            }
//        }
//        return maxWater;
//    }
    // Dynamic Programming
    public static int trap(int[] height) {
        if (height == null) return 0;
        int leftMax = 0, rightMax = 0, count = 0,sum = 0;

        for (int i = 0; i <height.length ; i++) {
            leftMax = Math.max(leftMax,height[i]);
            count += leftMax - height[i];
            sum += height[i];
        }
        for (int i = height.length -1 ; i >= 0 ; i--) {
            rightMax = Math.max(rightMax, height[i]);
            count += rightMax - height[i];
        }

        return count + sum - (leftMax * height.length);
    }


    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }
}