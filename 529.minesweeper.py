#
# @lc app=leetcode id=529 lang=python3
#
# [529] Minesweeper
#


# @lc code=start
class Solution:
    def updateBoard(self, board: list[list[str]], click: list[int]) -> list[list[str]]:
        row_count, col_count = len(board), len(board[0])
        i, j = click

        if board[i][j] == "M":
            board[i][j] = "X"
        elif board[i][j] == "E":
            self.reveal(board, i, j, row_count, col_count)
        return board

    def reveal(
        self, board: list[list[str]], i: int, j: int, row_count: int, col_count: int
    ) -> None:
        count = self.adjacent_mines_count(board, i, j, row_count, col_count)
        if count == 0:
            board[i][j] = "B"
            for x in range(max(0, i - 1), min(i + 2, row_count)):
                for y in range(max(0, j - 1), min(j + 2, col_count)):
                    if board[x][y] == "E":  # Only process unrevealed cells
                        self.reveal(board, x, y, row_count, col_count)
        else:
            board[i][j] = str(count)

    def adjacent_mines_count(
        self, board: list[list[str]], row: int, col: int, row_count: int, col_count: int
    ) -> int:
        count = 0
        for i in range(max(0, row - 1), min(row + 2, row_count)):
            for j in range(max(0, col - 1), min(col_count, col + 2)):
                if board[i][j] == "M" or board[i][j] == "X":
                    count += 1
        return count


# @lc code=end
if __name__ == "__main__":
    solution = Solution()
    # Test case 1
    board_1 = [
        ["E", "E", "E", "E", "E"],
        ["E", "E", "M", "E", "E"],
        ["E", "E", "E", "E", "E"],
        ["E", "E", "E", "E", "E"],
    ]
    click_1 = [3, 0]
    print(solution.updateBoard(board_1, click_1))
    # Test case 2
    board_2 = [
        ["B", "1", "E", "1", "B"],
        ["B", "1", "M", "1", "B"],
        ["B", "1", "1", "1", "B"],
        ["B", "B", "B", "B", "B"],
    ]
    click_2 = [1, 2]
    print(solution.updateBoard(board_2, click_2))
