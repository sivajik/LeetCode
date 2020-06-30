package leetcode.medium;

public class Prob516_LongestPalindromicSubseq_LPS {

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("bbbab"));

	}

	static public int longestPalindromeSubseq(String s) {
		int[][] dp = new int[s.length()][s.length()];

		for (int i = 0; i < s.length(); i++) {
			dp[i][i] = 1;
		}

		for (int i = s.length() -2; i >= 0; i--) {
			for (int j = 1; j < s.length(); j++) {
				if (i >= j) {
					continue;
				}

				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = 2 + dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[0][s.length() - 1];
	}
/*
	 [1, 2, 3, 3, 2], 
	 [0, 1, 2, 2, 2], 
	 [0, 0, 1, 1, 3], 
	 [0, 0, 0, 1, 1], 
	 [0, 0, 0, 0, 1] 
*/			
}
