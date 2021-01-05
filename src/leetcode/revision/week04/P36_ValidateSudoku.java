package leetcode.revision.week04;

import java.util.HashMap;

public class P36_ValidateSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public boolean isValidSudoku(char[][] board) {
		HashMap<Integer, Integer>[] rows = new HashMap[9];
		HashMap<Integer, Integer>[] cols = new HashMap[9];
		HashMap<Integer, Integer>[] boxs = new HashMap[9];

		for (int i = 0; i < 9; i++) {
			rows[i] = new HashMap<>();
			cols[i] = new HashMap<>();
			boxs[i] = new HashMap<>();
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int num = (int) board[i][j];
				if (num != '.') {
					// what a math???
					int boxId = (i / 3) * 3 + (j / 3);

					rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
					cols[i].put(num, cols[i].getOrDefault(num, 0) + 1);
					boxs[boxId].put(num, boxs[boxId].getOrDefault(num, 0) + 1);

					if (rows[i].get(num) > 1 || cols[j].get(num) > 1 || boxs[boxId].get(num) > 1) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
