package leetcode.hard;

import java.util.Arrays;

public class Prob37_SudokuSolver {

	public static void main(String[] args) {
		Solution s = new Solution();
		s.solveSudoku(new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } });

	}

	static class Solution {
		char[][] board;
		int n = 3;
		int N = n * n;

		boolean solved = false;

		int[][] rows = new int[N][N + 1]; // col is 1 based
		int[][] cols = new int[N][N + 1];
		int[][] boxes = new int[N][N + 1];

		public void solveSudoku(char[][] board) {
			this.board = board;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (board[i][j] != '.') {
						int d = Character.getNumericValue(board[i][j]);
						placeNumber(d, i, j);
					}
				}
			}
			backtrack(0, 0);

			for (char[] a : board) {
				System.out.println(Arrays.toString(a));
			}
		}

		private void backtrack(int r, int c) {
			if (board[r][c] == '.') {
				for (int d = 1; d <= 9; d++) {
					if (couldPlace(d, r, c)) {
						placeNumber(d, r, c);
						placeNextNumbers(r, c);

						if (!solved) {
							removeNumber(d, r, c);
						}
					}
				}
			} else {
				placeNextNumbers(r, c);
			}
		}

		private void placeNextNumbers(int r, int c) {
			if (r == N - 1 && c == N - 1) {
				solved = true;
			} else {
				if (c == N - 1) {
					backtrack(r + 1, 0); // 0th col
				} else {
					backtrack(r, c + 1);
				}
			}

		}

		private boolean couldPlace(int d, int r, int c) {
			int boxId = (r / 3) * 3 + (c / 3);

			return rows[r][d] + cols[c][d] + boxes[boxId][d] == 0;
		}

		private void placeNumber(int d, int r, int c) {
			int boxId = (r / 3) * 3 + (c / 3);

			rows[r][d]++;
			cols[c][d]++;
			boxes[boxId][d]++;
			board[r][c] = (char) (d + '0');
		}

		private void removeNumber(int d, int r, int c) {
			int boxId = (r / 3) * 3 + (c / 3);

			rows[r][d]--;
			cols[c][d]--;
			boxes[boxId][d]--;
			board[r][c] = '.';
		}
	}
}
