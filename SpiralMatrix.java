package com.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Creator:CharlesChaing
 * Date: 9/12/2019 AD
 * Description:Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length ==0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        spiral(0, m - 1, 0, n - 1, matrix, res);
        return res;
    }

    public static void spiral(int rStart, int rEnd, int cStart, int cEnd, int[][] matrix, List<Integer> res) {
        if (rStart > rEnd || cStart > cEnd) {
            return;

        } else if (rStart == rEnd) {
            for (int c = cStart; c <= cEnd; c++) {
                res.add(matrix[rStart][c]);
            }
            return;
        } else if (cStart == cEnd) {
            for (int r = rStart; r <= rEnd; r++) {
                res.add(matrix[r][cEnd]);
            }
            return;
        }else {
            for (int c = cStart; c <= cEnd; c++) {
                res.add(matrix[rStart][c]);
            }

            for (int r = rStart + 1; r < rEnd; r++) {
                res.add(matrix[r][cEnd]);
            }

            for (int c = cEnd; c >= cStart; c--) {
                res.add(matrix[rEnd][c]);
            }

            for (int r = rEnd - 1; r > rStart; r--) {
                res.add(matrix[r][cStart]);
            }
            spiral(rStart + 1, rEnd - 1, cStart + 1, cEnd - 1, matrix, res);
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1,2,3},
//                {4,5,6},
//                {7,8,9}
//        };
//        int[][] matrix = {
//                {1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9, 10, 11, 12}
//        };
        //int[][] matrix  = {{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}};
        int[][] matrix = {{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
        System.out.println(spiralOrder(matrix));
    }
}
