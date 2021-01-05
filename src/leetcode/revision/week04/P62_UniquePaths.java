package leetcode.revision.week04;

public class P62_UniquePaths {

	public static void main(String[] args) {
		System.out.println(uniquePaths(3, 7));
		System.out.println(uniquePaths(3, 2));
		System.out.println(uniquePaths(7, 3));
		System.out.println(uniquePaths(3, 3));
	}

	static public int uniquePaths(int m, int n) {
		// return solve(0, 0, m, n);

		int[][] dp = new int[m][n];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}

	private static int solve(int i, int j, int m, int n) {
		if (i >= m || j >= n) {
			return 0;
		}
		if (i == m - 1 && j == n - 1) {
			return 1;
		}
		return solve(i + 1, j, m, n) + solve(i, j + 1, m, n);
	}
}
