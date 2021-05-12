package leetcode.thirtydays.may21;

public class Day12_RangeSumQuery2D {

	public static void main(String[] args) {
		NumMatrix n = new NumMatrix(new int[][] {
			{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}
		});

		System.out.println(n.sumRegion(1,2,2,4));
	}

	static class NumMatrix {
		int[][] dp;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
				return;
			}
			dp = new int[matrix.length][matrix[0].length + 1];

			for (int i = 0; i < matrix.length; i++) {
				for (int j = 1; j <= matrix[i].length; j++) {
					dp[i][j] = dp[i][j - 1] + matrix[i][j - 1];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int sum = 0;
			for (int i = row1; i <= row2; i++) {
				sum += (dp[i][col2+1] - dp[i][col1]);
			}
			return sum;
		}
	}
}
