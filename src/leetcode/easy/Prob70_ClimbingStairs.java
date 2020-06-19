package leetcode.easy;

public class Prob70_ClimbingStairs {

	public static void main(String[] args) {
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(3));
	}

	static public int climbStairs(int n) {

		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;
		for (int j = 2; j <= n; j++) {
			dp[j] = dp[j - 1] + dp[j - 2];
		}
		// System.out.println(Arrays.toString(dp));
		return dp[n];

	}
}
