package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Creator:CharlesChaing
 * Date: 9/8/2019 AD
 * Description:The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 *
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 *
 * Example:
 *
 * Input: 4
 * Output: 2
 */
public class NQueens2 {
    public static int totalNQueens(int n) {
        return solve(new int[n], n,0,0);
    }
    public static int  solve(int[] board, int n, int r, int count) {

        if (r == n) {
            count++;
        } else {
            for (int c = 0; c < n; c++) {
                if(isValid(board, r, c)) {
                    board[r] = c;
                    count = solve(board, n,r + 1, count);
                    board[r] = 0;
                }
            }
        }
        return count;
    }
    public static boolean isValid(int[] board, int r, int c) {
        for (int i = 0; i <r ; i++) {
            if (board[i] == c || Math.abs(i - r) == Math.abs(board[i] - c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(5));
    }
}
