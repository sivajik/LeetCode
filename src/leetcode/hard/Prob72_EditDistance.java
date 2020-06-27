package leetcode.hard;

public class Prob72_EditDistance {

	public static void main(String[] args) {
		System.out.println(minDistance("h", "r"));
		// System.out.println(minDistance("horse", "ros"));
		// System.out.println(minDistance("intention", "execution"));
	}

	static public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int insertCount = dp[i][j-1];
					int deleteCount = dp[i-1][j];
					int replacCount = dp[i-1][j-1];
					dp[i][j] = 1 + Math.min(insertCount, Math.min(deleteCount, replacCount));
				}
			}
		}
		return dp[m][n];
	}
}
