package com.leetcode;

import java.util.*;

/**
 * Creator:CharlesChaing
 * Date: 2019-07-10
 * Description:
 */
public class Permutations2 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> baseList = new ArrayList<>();
        baseList.add(nums[0]);
        result.add(baseList);
        int start = 1;

        while(start < nums.length) {

            List<List<Integer>> newResult = new ArrayList<>();

            for (List<Integer> list : result) {
                for (int j = 0; j <= start; j++) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(j, nums[start]);

                    if(!newResult.contains(newList)) {

                        newResult.add(newList);
                    }
                    if (j < start && newList.get(j).equals(newList.get(j + 1))) {
                        j++;
                    }
                }
            }
            result = newResult;
            start ++;

        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        permuteUnique(nums);
    }
}
