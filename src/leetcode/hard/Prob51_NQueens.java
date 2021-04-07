package leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class Prob51_NQueens {

	public static void main(String[] args) {
		for (List<String> l : solveNQueens(5)) {
			for (String s : l) {
				System.out.println(s);
			}
			System.out.println("----");
		}

	}

	static public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		char[][] board = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}

		boolean[] columns = new boolean[n];
		boolean[] diag = new boolean[2 * n - 1];
		boolean[] revdiag = new boolean[2 * n - 1];

		nQueens(board, 0, columns, diag, revdiag, res);
		return res;
	}

	private static void nQueens(char[][] board, int currRow, boolean[] columns, boolean[] diag, boolean[] revdiag,
			List<List<String>> res) {
		if (currRow == board.length) {
			res.add(constructString(board));
			return;
		}

		for (int currCol = 0; currCol < board.length; currCol++) {
			// try placing in given col - assuming all good
			if (columns[currCol] == false && diag[currRow + currCol] == false && revdiag[currRow - currCol + board.length - 1] == false) {
				// set the cell as occupied
				board[currRow][currCol] = 'Q';
				diag[currRow + currCol] = true;
				revdiag[currRow - currCol + board.length - 1] = true;
				columns[currCol] = true;

				// call
				nQueens(board, currRow + 1, columns, diag, revdiag, res);

				// and backtrack.
				board[currRow][currCol] = '.';
				diag[currRow + currCol] = false;
				revdiag[currRow - currCol + board.length - 1] = false;
				columns[currCol] = false;
			}
		}

	}

	public static List<String> constructString(char[][] board) {
		List<String> res = new ArrayList<String>();
		for (char[] eachRow : board) {
			res.add(new String(eachRow));
		}
		return res;
	}
}
