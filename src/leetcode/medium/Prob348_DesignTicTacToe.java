package leetcode.medium;

public class Prob348_DesignTicTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class TicTacToe {
		int n;
		int[][] rows;
		int[][] cols;
		int[][] diag;

		public TicTacToe(int n) {
			this.n = n;
			this.rows = new int[2][n];
			this.cols = new int[2][n];
			this.diag = new int[2][2];
		}

		public int move(int row, int col, int player) {
			rows[player - 1][row]++;
			cols[player - 1][col]++;
			if (row == col) {
				diag[player - 1][0]++;
			}
			if (row + col == n - 1) {
				diag[player - 1][1]++;
			}

			if (rows[player - 1][row] == n || cols[player - 1][col] == n || diag[player - 1][0] == n
					|| diag[player - 1][1] == n) {
				return player;
			}
			return 0;
		}

	}
}
