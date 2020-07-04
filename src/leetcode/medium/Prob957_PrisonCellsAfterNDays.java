package leetcode.medium;

import java.util.Arrays;

public class Prob957_PrisonCellsAfterNDays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(prisonAfterNDays(new int[] { 0, 1, 0, 1, 1, 0, 0, 1 }, 7)));
		System.out.println(Arrays.toString(prisonAfterNDays(new int[] { 1,0,0,1,0,0,1,0 }, 1000000000)));
	}

	static public int[] prisonAfterNDays(int[] cells, int N) {
		if (N >= 15) {
			N = 1 + ((N - 1) % 14);
		}

		for (int i = 0; i < N; i++) {
			int[] temp = cells.clone();
			for (int col = 1; col <= 6; col++) {
				temp[col] = cells[col - 1] == cells[col + 1] ? 1 : 0;
			}
			temp[0] = 0;
			temp[7] = 0;

			cells = temp.clone();
			// System.out.printf("Day %2d" + ": " + java.util.Arrays.toString(temp) + "\n", (i + 1));
		}
		return cells;
	}
}
