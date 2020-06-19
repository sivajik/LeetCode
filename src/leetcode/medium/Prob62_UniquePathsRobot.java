package leetcode.medium;

public class Prob62_UniquePathsRobot {

	public static void main(String[] args) {
		System.out.println(uniquePaths(7, 3) + " == " + uniquePaths1(7, 3));
		System.out.println(uniquePaths(3, 2) + " == " + uniquePaths1(3, 2));
	}

	static public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];

		java.util.Arrays.fill(dp[0], 1);
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	static public int uniquePaths1(int m, int n) {
		int[][] grid = new int[m][n];
		return solve(grid, 0, 0);
	}

	private static int solve(int[][] grid, int i, int j) {
		if (i >= grid.length || j >= grid[0].length) {
			return 0;
		}
		if (i == grid.length - 1 && j == grid[0].length - 1) {
			return 1;
		}
		return solve(grid, i + 1, j) + solve(grid, i, j + 1);
	}
}
