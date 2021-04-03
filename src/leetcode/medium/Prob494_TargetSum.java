package leetcode.medium;

import java.util.Arrays;

public class Prob494_TargetSum {

	public static void main(String[] args) {
		System.out.println(findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));

	}

	static public int findTargetSumWays(int[] nums, int S) {
		// max sum is 1000 so better to keep 2*1000+1
		int[][] memo = new int[nums.length][2001];
		for (int[] eachRow : memo) {
			Arrays.fill(eachRow, Integer.MIN_VALUE);
		}
		return calc(nums, 0, S, memo, 0);
	}

	static private int calc(int[] nums, int sum, int S, int[][] memo, int i) {
		if (i == nums.length) {
			if (sum == S) {
				return 1;
			} else {
				return 0;
			}
		}
		if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
			return memo[i][sum + 1000];
		}

		int add = calc(nums, sum + nums[i], S, memo, i + 1);
		int sub = calc(nums, sum - nums[i], S, memo, i + 1);
		memo[i][sum + 1000] = add + sub;
		return memo[i][sum + 1000];
	}
}
