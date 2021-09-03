package leetcode.revision.week04;

import java.util.Arrays;

public class P130_SurroundedRegions {

	public static void main(String[] args) {
		char[][] board = /*new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };*/
				new char[][] {
			{'O','O','O'},{'O','O','O'},{'O','O','O'}
		};
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

	static public void solve(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return;
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
					if (board[i][j] == 'O') {
						board[i][j] = '=';
					}
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O') {
					helper(board, i, j);
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (i == 0 || i == board.length - 1 || j == 0 || j == board[i].length - 1) {
					if (board[i][j] == '=') {
						board[i][j] = 'O';
					}
				}
			}
		}
	}

	private static void helper(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == 'X') {
			return;
		}

		board[i][j] = 'X';
		helper(board, i - 1, j);
		helper(board, i + 1, j);
		helper(board, i, j + 1);
		helper(board, i, j - 1);

	}
}
