package com.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Creator:CharlesChaing
 * Date: 9/5/2019 AD
 * Description:The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens
 * attack each other.
 *
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate
 * a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 */
public class NQueens {
    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>(n);
        solve(n,0, new boolean[n], new boolean[2*n -1], new boolean[2*n -1 ],new ArrayList<String>(), result);
        return result;
    }

    public static void  solve(int n, int r, boolean[] cols, boolean[] diagonal1, boolean[] diagonal2, List<String> board,
                                  List<List<String>> res) {

        if (r == n) {
            res.add(new ArrayList<>(board));
            return;
        } else {
            for (int c = 0; c < n; c++) {
                int id1 = c + r,id2 = r - c + n -1;

                if (!cols[c] && !diagonal1[id1] && !diagonal2[id2]) {
                    cols[c] = true;
                    diagonal1[id1] = true;
                    diagonal2[id2] = true;
                    char[] curRow = new char[n];
                    Arrays.fill(curRow, '.');
                    curRow[c] = 'Q';
                    board.add(new String(curRow));

                    solve(n,r + 1, cols, diagonal1, diagonal2, board, res);

                    cols[c] = false;
                    diagonal1[id1] = false;
                    diagonal2[id2] = false;
                    board.remove(board.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4).size());
    }
}
