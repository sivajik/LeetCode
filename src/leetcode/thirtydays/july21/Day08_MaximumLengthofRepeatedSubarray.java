package leetcode.thirtydays.july21;

public class Day08_MaximumLengthofRepeatedSubarray {

	public static void main(String[] args) {
		System.out.println(findLength(new int[] { 1, 2, 3, 2, 1 }, new int[] { 3, 2, 1, 4, 7 }));

	}

	static public int findLength(int[] A, int[] B) {
		if (A.length == 0 || B.length == 0) {
			return 0;
		}

		int[][] dp = new int[A.length + 1][B.length + 1];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else {
					if (A[i - 1] == B[j - 1]) {
						dp[i][j] = 1 + dp[i - 1][j - 1];
					} else {
						dp[i][j] = 0;// Math.max(dp[i - 1][j], dp[i][j - 1]);
					}
				}
			}
		}
		return max(dp);
	}

	static private int max(int[][] dp) {
		int mx = Integer.MIN_VALUE;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				mx = Math.max(dp[i][j], mx);
			}
		}
		return mx;
	}
}
