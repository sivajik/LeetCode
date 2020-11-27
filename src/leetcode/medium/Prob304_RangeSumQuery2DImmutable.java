package leetcode.medium;

import java.util.Arrays;

public class Prob304_RangeSumQuery2DImmutable {

	public static void main(String[] args) {
		NumMatrix m = new NumMatrix(new int[][] { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 },
				{ 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } });
		System.out.println(m.sumRegion(2, 1, 4, 3));
	}

}

class NumMatrix {
	int[][] dp;

	public NumMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return;
		}

		dp = new int[matrix.length][matrix[0].length + 1];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 1; j <= matrix[0].length; j++) {
				dp[i][j] = dp[i][j - 1] + matrix[i][j - 1];
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		for (int i = row1; i <= row2; i++) {
			sum += (dp[i][col2 + 1] - dp[i][col1]);
		}
		return sum;
	}
}