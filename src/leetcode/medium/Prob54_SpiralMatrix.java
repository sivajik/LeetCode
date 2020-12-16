package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob54_SpiralMatrix {

	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } }));
		System.out.println(spiralOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));

	}

	static public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> l = new ArrayList<>();
		if (matrix == null || matrix[0].length == 0) {
			return l;
		}

		int rowCount = matrix.length;
		int colCount = matrix[0].length;

		boolean[][] seen = new boolean[rowCount][colCount];

		int[] rowDir = new int[] { 0, 1, 0, -1 };
		int[] colDir = new int[] { 1, 0, -1, 0 };

		int r = 0, c = 0;
		int di = 0;
		for (int i = 0; i < rowCount * colCount; i++) {
			l.add(matrix[r][c]);
			seen[r][c] = true;

			int newR = r + rowDir[di];
			int newC = c + colDir[di];
			if (newR >= 0 && newR < rowCount && newC >= 0 && newC < colCount && seen[newR][newC] == false) {
				r = newR;
				c = newC;
			} else {
				di = (di + 1) % 4;
				r = r + rowDir[di];
				c = c + colDir[di];
			}
		}
		return l;
	}
}
