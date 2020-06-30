package leetcode.medium;

public class Prob62_UniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(7, 3));
		System.out.println(uniquePaths(3, 2));
		System.out.println(uniquePaths(1, 1));
		System.out.println(uniquePaths(100, 100));
	}

	static public int uniquePaths(int m, int n) {
		int rows = n;
		int cols = m;
		int[][] dp = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[rows - 1][cols - 1];
	}
}
