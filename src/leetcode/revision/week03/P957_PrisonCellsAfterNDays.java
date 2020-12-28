package leetcode.revision.week03;

import java.util.Arrays;
import java.util.*;

public class P957_PrisonCellsAfterNDays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(prisonAfterNDays(new int[] { 0, 1, 0, 1, 1, 0, 0, 1 }, 7)));
		System.out.println(Arrays.toString(prisonAfterNDays(new int[] { 1, 0, 0, 1, 0, 0, 1, 0 }, 1000000000)));
	}

	static public int[] prisonAfterNDays(int[] cells, int N) {
		Set<String> m = new HashSet<>();
		int len = 0;

		boolean cycle = false;

		for (int i = 0; i < N; i++) {
			int[] temp = updateCells(cells);
			String s = Arrays.toString(temp);
			if (m.contains(s)) {
				cycle = true;
				break;
			}
			m.add(s);
			len++;
			cells = temp;
		}

		if (cycle) {
			return prisonAfterNDays(cells, N % len);
		}
		return cells;
	}

	private static int[] updateCells(int[] cells) {
		int[] temp = new int[8];
		for (int col = 1; col <= 6; col++) {
			temp[col] = cells[col - 1] == cells[col + 1] ? 1 : 0;
		}
		return temp;
	}
}
