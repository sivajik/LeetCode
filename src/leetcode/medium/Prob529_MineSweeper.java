package leetcode.medium;

public class Prob529_MineSweeper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static class Solution {

		int m, n;
		final int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { 1, -1 },
				{ -1, 1 }, { -1, -1 } };

		public char[][] updateBoard(char[][] board, int[] click) {
			m = board.length;
			n = board[0].length;

			int cRow = click[0];
			int cCol = click[1];

			if (board[cRow][cCol] == 'E') {
				clickE(board, cRow, cCol);
			}

			if (board[cRow][cCol] == 'M') {
				board[cRow][cCol] = 'X';
			}
			return board;
		}

		private void clickE(char[][] board, int cRow, int cCol) {
			if (!boundCheck(cRow, cCol) || board[cRow][cCol] != 'E') {
				return;
			}

			board[cRow][cCol] = 'B';
			int mineCount = countMines(board, cRow, cCol);

			if (mineCount > 0) {
				board[cRow][cCol] = (char) (mineCount + '0');
				return;
			}

			for (int i = 0; i < directions.length; i++) {
				int nextRow = cRow + directions[i][0];
				int nextCol = cCol + directions[i][1];

				clickE(board, nextRow, nextCol);
			}
		}

		private boolean boundCheck(int row, int col) {
			return row >= 0 && row < m && col >= 0 && col < n;
		}

		private int countMines(char[][] board, int row, int col) {
			int mineCount = 0;

			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					int nextRow = row + i;
					int nextCol = col + j;

					if (boundCheck(nextRow, nextCol) && board[nextRow][nextCol] == 'M')
						mineCount++;
				}
			}

			return mineCount;
		}
	
}
}
