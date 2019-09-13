package com.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Creator:CharlesChaing
 * Date: 2019-07-21
 * Description:39. Combination Sum
 */
public class CombinationSum {
    /**
     * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
     * find all unique combinations in candidates where the candidate numbers sums to target.
     * <p>
     * The same repeated number may be chosen from candidates unlimited number of times.
     * <p>
     * Note:
     * <p>
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     * <p>
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     * [7],
     * [2,2,3]
     * ]
     * Example 2:
     * <p>
     * Input: candidates = [2,3,5], target = 8,
     * A solution set is:
     * [
     * [2,2,2,2],
     * [2,3,3],
     * [3,5]
     * ]
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(result, new ArrayList<>(),candidates, target, 0);
        return result;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> record, int[] candinates,
                                 int remain, int start) {
        if (remain < 0) {
            return;
        } else if (remain == 0) {
            list.add(new ArrayList<>(record));
        } else {
            for (int i = start; i < candinates.length && remain - candinates[i] >= 0; i++) {
                record.add(candinates[i]);
                backtrack(list, record, candinates, remain - candinates[i], i);
                record.remove(record.size() -1);
            }
        }

    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] candidates = {1,2, 3,4,5, 6, 7,8,9,10,11,13};
        int target = 13;
        System.out.println(combinationSum(candidates, target));
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
