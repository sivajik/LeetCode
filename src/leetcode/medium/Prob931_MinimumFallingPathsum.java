package leetcode.medium;

import java.util.Arrays;

public class Prob931_MinimumFallingPathsum {

	public static void main(String[] args) {
		System.out.println(minFallingPathSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		System.out.println(minFallingPathSum(new int[][] { { -19, 57 }, { -40, -5 } }));
	}

	static public int minFallingPathSum(int[][] A) {
		int res = Integer.MAX_VALUE;

		for (int r = 0; r < A.length; r++) {
			for (int c = 0; c < A.length; c++) {
				if (r == 0) {
					continue;
				}

				if (r > 0 && c == 0) {
					int top = get(A, r - 1, c);
					int rit = get(A, r - 1, c + 1);
					A[r][c] = A[r][c] + Math.min(top, rit);
				} else if (c == A.length - 1) {
					int top = get(A, r - 1, c);
					int lef = get(A, r - 1, c - 1);
					A[r][c] = A[r][c] + Math.min(top, lef);
				} else {
					int top = get(A, r - 1, c);
					int lef = get(A, r - 1, c - 1);
					int rit = get(A, r - 1, c + 1);
					A[r][c] = A[r][c] + Math.min(top, Math.min(lef, rit));
				}

			}
		}

		for (int[] elem : A) {
			System.out.println(Arrays.toString(elem));
		}

		for (int elem : A[A.length - 1]) {
			res = Math.min(res, elem);
		}
		return res;
	}

	private static int get(int[][] a, int r, int c) {
		if (r < 0 || c < 0 || r >= a.length || c >= a.length) {
			return 0;
		}
		return a[r][c];
	}
}
