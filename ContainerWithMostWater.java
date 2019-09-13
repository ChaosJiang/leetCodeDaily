package com.leetcode;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: ContainerWithMostWater
 * Creator: Chiang
 * Date: 2019-05-11
 * Description: 11. Container With Most Water
 */
public class ContainerWithMostWater {
    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at
     * coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line
     * i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container,
     * such that the container contains the most water.
     * <p>
     * Note: You may not slant the container and n is at least 2.
     * <p>
     * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
     * the max area of water (blue section) the container can contain is 49.
     * <p>
     * Example:
     * <p>
     * Input: [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * <p>
     * Brute Force
     * We will simply consider the area of every possible pair of the
     * lines and find out the maximum out of those.
     */
    public int maxArea(int[] height) {
        int length = height.length;
        int area = 0, maxArea = 0;
        if (length < 2) {
            return 0;
        }

        for (int i = 0; i < length; i++) {

            for (int j = i + 1; j < length; j++) {
                if (height[i] >= height[j]) {
                    area = (j - i) * height[j];
                } else {
                    area = (j - i) * height[i];
                }
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    /**
     * We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines. Futher, we maintain a variable
     * maxarea
     * maxarea to store the maximum area obtained till now. At every step, we find out the area formed between them, update
     * maxarea
     * maxarea and move the pointer pointing to the shorter line towards the other end by one step.
     */

    public int maxArea2(int[] height) {

        int head = 0, tail = height.length - 1;
        int maxArea = 0;

        while (head < tail) {
            if (height[head] <= height[tail]) {
                maxArea = Math.max(maxArea, height[head] * (tail - head));
                head++;
            } else {
                maxArea = Math.max(maxArea, height[tail] * (tail - head));
                tail--;
            }
        }
        return maxArea;
    }
}
