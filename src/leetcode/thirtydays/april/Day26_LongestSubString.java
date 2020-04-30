package leetcode.thirtydays.april;

public class Day26_LongestSubString {

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcdef", "abc"));
		System.out.println(longestCommonSubsequence("def", "abc"));
	}

	public static int longestCommonSubsequence(String text1, String text2) {
		char[] textA = text1.toCharArray();
		char[] textB = text2.toCharArray();

		int m = textA.length;
		int n = textB.length;

		int[][] finalArray = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			finalArray[i][0] = 0;
		}

		for (int i = 0; i < n + 1; i++) {
			finalArray[0][i] = 0;
		}

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (textA[i - 1] == textB[j - 1]) {
					finalArray[i][j] = finalArray[i - 1][j - 1] + 1;
				} else {
					finalArray[i][j] = Math.max(finalArray[i - 1][j], finalArray[i][j - 1]);
				}
			}
		}
		return finalArray[m][n];
	}
}
