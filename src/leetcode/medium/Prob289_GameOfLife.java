package leetcode.medium;

import java.util.Arrays;

public class Prob289_GameOfLife {

	public static void main(String[] args) {
		int[][] board = new int[][] { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		gameOfLife(board);
		for (int[] a : board) {
			System.out.println(Arrays.toString(a));
		}
	}

	static public void gameOfLife(int[][] board) {
		/*
		 * Any live cell with 'fewer than two' live neighbors dies as if caused by
		 * under-population. 
		 * 
		 * Any live cell with 'more than three' live neighbors dies,
		 * as if by over-population. 
		 * 
		 * Any live cell with two or three live neighbors lives on to
		 * the next generation. 
		 * 
		 * Any dead cell with exactly three live neighbors
		 * becomes a live cell, as if by reproduction.
		 */

		int rows = board.length;
		int cols = board[0].length;

		int[][] copyBoard = new int[rows][cols];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				copyBoard[i][j] = board[i][j];
			}
		}

		int[][] nbrs = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
				{ 1, 1 } };
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {

				int liveNeightboutCount = 0;

				for (int[] neighbours : nbrs) {
					int r = row + neighbours[0];
					int c = col + neighbours[1];

					if (r >= 0 && r < rows && c >= 0 && c < cols && copyBoard[r][c] == 1) {
						liveNeightboutCount++;
					}
				}

				if (copyBoard[row][col] == 1 && (liveNeightboutCount < 2 || liveNeightboutCount > 3)) {
					board[row][col] = 0;
				}

				if (copyBoard[row][col] == 0 && liveNeightboutCount == 3) {
					board[row][col] = 1;
				}
			}
		}
	}

}
