package leetcode.medium;

import java.util.Arrays;

public class Prob130_SurroundedRegions {

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		print(board);
		solve(board);
		print(board);
	}

	private static void print(char[][] board) {
		for (char[] row : board) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println();
	}

	static private void floodFill(char[][] board, int x, int y, char prevC, char newC) {
		if (x >= board.length || x < 0 || y < 0 || y >= board[0].length) {
			return;
		}
		if (board[x][y] != prevC) {
			return;
		}

		board[x][y] = newC;

		floodFill(board, x, y + 1, prevC, newC);
		floodFill(board, x, y - 1, prevC, newC);
		floodFill(board, x - 1, y, prevC, newC);
		floodFill(board, x + 1, y, prevC, newC);
	}

	static public void solve(char[][] board) {
		if (board.length == 0) {
			return;
		}
		if (board[0].length == 0) {
			return;
		}
		
		int rows = board.length;
		int cols = board[0].length;

		// step 1: replace O with -
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = '-';
				}
			}
		}
		// step 2: replace - with O for all edge elements..

		// left
		for (int i = 0; i < rows; i++) {
			if (board[i][0] == '-') {
				floodFill(board, i, 0, '-', 'O');
			}
		}

		// right
		for (int i = 0; i < rows; i++) {
			if (board[i][cols - 1] == '-') {
				floodFill(board, i, cols - 1, '-', 'O');
			}
		}

		// top
		for (int i = 0; i < cols; i++) {
			if (board[0][i] == '-') {
				floodFill(board, 0, i, '-', 'O');
			}
		}

		// bottom
		for (int i = 0; i < cols; i++) {
			if (board[rows - 1][i] == '-') {
				floodFill(board, rows - 1, i, '-', 'O');
			}
		}

		// step 3: replace all - with X
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == '-') {
					board[i][j] = 'X';
				}
			}
		}
	}
}
