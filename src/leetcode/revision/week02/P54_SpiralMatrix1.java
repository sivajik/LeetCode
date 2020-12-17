package leetcode.revision.week02;

import java.util.ArrayList;
import java.util.List;

public class P54_SpiralMatrix1 {

	public static void main(String[] args) {
		System.out.println(spiralOrder(new int[][] {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12}
		}));

	}

	static public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> l = new ArrayList<>();

		if (matrix == null || matrix[0].length == 0) {
			return l;
		}

		int rowsCount = matrix.length;
		int colsCount = matrix[0].length;

		int r = 0, c = 0, di = 0;
		boolean[][] seen = new boolean[rowsCount][colsCount];

		int[] rowDir = { 0, 1, 0, -1 };
		int[] colDir = { 1, 0, -1, 0 };

		for (int i = 0; i < rowsCount * colsCount; i++) {
			l.add(matrix[r][c]);
			seen[r][c] = true;

			int newR = r + rowDir[di];
			int newC = c + colDir[di];

			if (newR < 0 || newC < 0 || newR >= rowsCount || newC >= colsCount || seen[newR][newC] == true) {
				di = (di + 1) % 4;
				r = r + rowDir[di];
				c = c + colDir[di];
			} else {
				r = newR;
				c = newC;
			}
		}
		return l;
	}
}
