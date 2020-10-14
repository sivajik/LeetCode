package leetcode.medium;

import java.util.Arrays;

public class Prob213_HoseRobber2 {

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 2, 3, 2 }));
		System.out.println(rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(rob(new int[] { 0 }));
	}

	static public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int leftArr = findMaxProfit(Arrays.copyOfRange(nums, 0, nums.length - 1));
		int riteArr = findMaxProfit(Arrays.copyOfRange(nums, 1, nums.length));
		return Math.max(leftArr, riteArr);
	}

	static int findMaxProfit(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);

		for (int i = 2; i < arr.length; i++) {
			dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[arr.length - 1];
	}
}
