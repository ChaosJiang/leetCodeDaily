package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creator:CharlesChaing
 * Date: 2019-07-22
 * Description:40. Combination Sum II
 */
public class CombinationSum2 {
    /**
     * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations
     * in candidates where the candidate numbers sums to target.
     * <p>
     * Each number in candidates may only be used once in the combination.
     * <p>
     * Note:
     * <p>
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     * <p>
     * Input: candidates = [10,1,2,7,6,1,5], target = 8,
     * A solution set is:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     * Example 2:
     * <p>
     * Input: candidates = [2,5,2,1,2], target = 5,
     * A solution set is:
     * [
     * [1,2,2],
     * [5]
     * ]
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backTracking(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public static void backTracking(List<List<Integer>> list, List<Integer> record, int[] candidates, int target,
                                    int start) {
        if (target == 0) {
            list.add(new ArrayList(record));
        } else {
            for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
                if (i > start && candidates[i] == candidates[i -1]) continue;
                record.add(candidates[i]);
                backTracking(list, record, candidates, target - candidates[i], i + 1);
                record.remove(record.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int[] candidates = {2,5,2,1,2,3,4,5,6,4,7,8,11};
        int target = 15;
        combinationSum2(candidates, target);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
