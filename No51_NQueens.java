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
public class No51_NQueens {
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

    public List<List<String>> solveNQueens2(int n) {
        // solution list
        List<List<String>> solutions = new ArrayList<List<String>>();
        // record
        Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        // init
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        // 回溯法
        backTrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    public void backTrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns,
                              Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if(n == row) {
            solutions.add(generateCheese(queens, n));
        } else {
            for (int i = 0; i < n; i++) {
                if(columns.contains(i)) {
                    continue;
                }
                int diagonal1 = row - i;
                if(diagonals1.contains(diagonal1)) {
                    continue;
                }
                int diagonal2 = row + i;
                if(diagonals2.contains(diagonal2)) {
                    continue;
                }
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);

                backTrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }

    }

    // Generate full solution from an array of column indices.
    public List<String> generateCheese(int[] queens, int n) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            solution.add(new String(row));
        }
        return solution;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4).size());
    }
}
