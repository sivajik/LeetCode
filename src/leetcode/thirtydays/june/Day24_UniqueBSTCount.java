package leetcode.thirtydays.june;

public class Day24_UniqueBSTCount {

	public static void main(String[] args) {
		System.out.println(numTrees(3));
		System.out.println(numTrees(11));
	}

	static public int numTrees(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[n];
	}
}
