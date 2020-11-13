package leetcode.medium;

public class Prob1143_LongestCommonSubsequence {

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcdef", "abc"));
		System.out.println(longestCommonSubsequence("def", "abc"));
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		char[] textA = text1.toCharArray();
		char[] textB = text2.toCharArray();

		int m = textA.length;
		int n = textB.length;

		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = 0;
		}

		for (int i = 0; i < n + 1; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (textA[i - 1] == textB[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}

}
