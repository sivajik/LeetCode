package leetcode.thirtydays.june21;

public class P07_MinCostClimbingStars {

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] { 10, 15, 20 }) == 15);
		System.out.println(minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 }) == 6);
	}

	static public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length + 1];
		dp[0] = 0;// cost[0];
		dp[1] = 0;// Math.min(cost[0], cost[1]);

		for (int i = 2; i <= cost.length; i++) {
			dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
		}
		return dp[cost.length];
	}
}
