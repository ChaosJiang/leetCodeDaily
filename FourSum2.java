package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Project Name: leetcode
 * Package Name: leetcode
 * File Name: FourSum2
 * Creator: Chiang
 * Date: 2019-05-19
 * Description:454. 4Sum II
 */
public class FourSum2 {
    /**
     * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
     * <p>
     * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
     * <p>
     * Example:
     * <p>
     * Input:
     * A = [ 1, 2]
     * B = [-2,-1]
     * C = [-1, 2]
     * D = [ 0, 2]
     * <p>
     * Output:
     * 2
     * <p>
     * Explanation:
     * The two tuples are:
     * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 =
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        int length = A.length;
        int tail = length - 1;
        if (A == null || B == null || C == null || D == null || length < 0 || length > 500) {
            return 0;
        }

        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);

        int sumTarget = 0;
        int sum = 0, minSum = 0, maxSum = 0;
        for (int a : A) {


            sumTarget = 0 - a;
            minSum = B[0] + C[0] + D[0];
            maxSum = B[tail] + D[tail] + D[tail];
            if (sumTarget < minSum || sumTarget > maxSum) {
                continue;
            }
            for (int b : B) {

                sumTarget = 0 - a - b;
                minSum = C[0] + D[0];
                maxSum = D[tail] + D[tail];
                if (sumTarget < minSum || sumTarget > maxSum) {
                    continue;
                }

                for (int c : C) {

                    sumTarget = 0 - a - b - c;
                    minSum = D[0];
                    maxSum = D[tail];
                    if (sumTarget < minSum || sumTarget > maxSum) {
                        continue;
                    }
                    for (int d : D) {
                        if (a + b + c + d == 0) {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public int fourSumCount2(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                int sumAB = a + b;
                map.put(sumAB, map.getOrDefault(sumAB, 0) + 1);
            }
        }

        for (int c : C) {
            for (int d : D) {
                int sum = -(c + d);
                res += map.getOrDefault(sum, 0);
            }
        }
        return res;
    }
}
