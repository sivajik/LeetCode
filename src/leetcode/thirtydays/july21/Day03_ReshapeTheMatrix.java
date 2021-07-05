package leetcode.thirtydays.july21;

import java.util.Arrays;

public class Day03_ReshapeTheMatrix {

	public static void main(String[] args) {
		print(matrixReshape(new int[][] { { 1, 2 }, { 3, 4 } }, 1, 4));
		print(matrixReshape(new int[][] { { 1, 2 }, { 3, 4 } }, 2, 4));

	}

	static public int[][] matrixReshape(int[][] mat, int r, int c) {
		int mr = mat.length;
		int mc = mat[0].length;

		if (r * c != mr * mc) {
			return mat;
		} else {
			int[][] op = new int[r][c];
			int[] orig = new int[mr * mc];
			int k = 0;
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[i].length; j++) {
					orig[k++] = mat[i][j];
				}
			}
			k = 0;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					op[i][j] = orig[k++];
				}
			}
			return op;
		}
	}

	static void print(int[][] a) {
		for (int[] aa : a) {
			System.out.println(Arrays.toString(aa));
		}
	}
}
