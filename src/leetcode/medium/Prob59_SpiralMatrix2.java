package leetcode.medium;

import java.util.Arrays;

public class Prob59_SpiralMatrix2 {

	public static void main(String[] args) {
		for (int[] a : generateMatrix(3)) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
		
		for (int[] a : generateMatrix(1)) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
		
		for (int[] a : generateMatrix(4)) {
			System.out.println(Arrays.toString(a));
		}
	}

	static public int[][] generateMatrix(int n) {
		int[][] ans = new int[n][n];
		fill(ans, 0, 0, 1, 'r');
		return ans;
	}

	static private void fill(int[][] ans, int i, int j, int currVal, char c) {
		if (i < 0 || j < 0 || i >= ans.length || j >= ans[i].length) {
			return;
		}

		if (ans[i][j] != 0) {
			return;
		}
		
		ans[i][j] = currVal;

		if (c == 'u') {
			fill(ans, i - 1, j, currVal + 1, 'u');
		}
		
		fill(ans, i, j + 1, currVal + 1, 'r');
		fill(ans, i + 1, j, currVal + 1, 'd');
		fill(ans, i, j - 1, currVal + 1, 'l');
		fill(ans, i - 1, j, currVal + 1, 'u');
	}
}
