package com.leetcode;

import java.util.Arrays;
/**
 * Creator:CharlesChaing
 * Date: 2019-07-17
 * Description:37. Sudoku Solver
 */
public class SudokuSolver {
    /**
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     * <p>
     * A sudoku solution must satisfy all of the following rules:
     * <p>
     * Each of the digits 1-9 must occur exactly once in each row.
     * Each of the digits 1-9 must occur exactly once in each column.
     * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of
     * the grid.
     * Empty cells are indicated by the character '.'.
     * <p>
     * <p>
     * A sudoku puzzle...
     * <p>
     * <p>
     * ...and its solution numbers marked in red.
     * <p>
     * Note:
     * <p>
     * The given board contain only digits 1-9 and the character '.'.
     * You may assume that the given Sudoku puzzle will have a single unique solution.
     * The given board size is always 9x9.
     */
//    public static void solveSudoku(char[][] board) {
//        List<List<Character>> rowTrack = new ArrayList<>(9);
//        List<List<Character>> colTrack = new ArrayList<>(9);
//        List<List<Character>> blockTrack = new ArrayList<>(9);
//
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//
//                if (board[i][j] != '.') {
//                    rowTrack.get(i).add(board[i][j]);
//                }
//
//                if (board[j][i] != '.') {
//                    colTrack.get(j).add(board[j][i]);
//                }
//
//                int rowIndex = 3 * (i / 3);
//                int colIndex = 3 * (i % 3);
//                char block = board[rowIndex + j / 3][colIndex + j % 3];
//                if (block != '.') {
//                    blockTrack.get(rowIndex + j / 3).add(block);
//                }
//            }
//
//
//        }
//
//        int row = 0,col = 0;
//        while (row >= 0 && row < 9) {
//            while (col >= 0 && col < 9) {
//
//                if (board[row][col] != '.') continue;
//                char temp = '0';
//                while(rowTrack.get(row).contains(temp) || colTrack.get(col).contains(temp) ||
//                        blockTrack.get(3 * (row / 3) + col / 3).contains(temp)) {
//                    temp++;
//                }
//                if(temp <= '9') {
//                    board[row][col] = temp;
//                    col++;
//                } else {
//                    col--;
//                    board[row][col] += 1;
//                }
//
//            }
//            row++;
//        }
//    }
    public static void solveSudoku(char[][] board) {
        dfs(board,0);
    }
    private static boolean dfs(char[][] board, int d) {
        if (d==81) return true; //found solution
        int i=d/9, j=d%9;
         if (board[i][j]!='.') return dfs(board,d+1);//prefill number skip

        boolean[] flag=new boolean[10];
        validate(board,i,j,flag);
        for (int k=1; k<=9; k++) {
            if (flag[k]) {
                board[i][j]=(char)('0'+k);
                if (dfs(board,d+1)) return true;
            }
        }
        board[i][j]='.'; //if can not solve, in the wrong path, change back to '.' and out
        return false;
    }
    private static void validate(char[][] board, int i, int j, boolean[] flag) {
        Arrays.fill(flag,true);
        for (int k=0; k<9; k++) {
            if (board[i][k]!='.') flag[board[i][k]-'0']=false;
            if (board[k][j]!='.') flag[board[k][j]-'0']=false;
            int r=i/3*3+k/3;
            int c=j/3*3+k%3;
            if (board[r][c]!='.') flag[board[r][c]-'0']=false;
        }
    }
    public static void main(String[] args) {
        char[][] sudoku = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(sudoku);
    }
}
