package leetcode.revision.week03;

import java.util.Arrays;

public class P213_HouseRobberII {

	public static void main(String[] args) {
		// System.out.println(rob(new int[] { 2, 3, 2 }));
		System.out.println(rob(new int[] { 1, 2, 3, 1 }));
		// System.out.println(rob(new int[] { 0 }));
	}

	static public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}

		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int profit1 = robbb(nums, 0, nums.length - 1);
		int profit2 = robbb(nums, 1, nums.length);
		return Math.max(profit1, profit2);
	}

	private static int robbb(int[] nums, int i, int length) {
		int[] num = Arrays.copyOfRange(nums, i, length);

		int[] dp = new int[num.length];
		dp[0] = num[0];
		dp[1] = Math.max(num[0], num[1]);
		for (int ii = 2; ii < dp.length; ii++) {
			dp[ii] = Math.max(num[ii] + dp[ii - 2], dp[ii - 1]);
		}
		return dp[dp.length - 1];
	}
}
