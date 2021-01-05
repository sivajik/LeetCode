package leetcode.revision.week04;

public class P96_UniqueBinarySearchTrees {

	public static void main(String[] args) {
		System.out.println(numTrees(3));

	}
	// OR do it by 2n!/ n! * (n+1)!
	static public int numTrees(int n) {
		int[] dp = new int[1 + n];

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
