package leetcode.thirtydays.july21;

import java.util.Arrays;

public class Day09_LIS {

	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
	}

	static public int lengthOfLIS(int[] nums) {
		int[] res = new int[nums.length];
		Arrays.fill(res, 1);

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				// the recurrence relation is: dp[i] = max(dp[j] + 1) for all j where nums[j] < nums[i] and j < i.
				// or keep res[i] as it is.
				if (nums[j] < nums[i]) {
					res[i] = Math.max(res[i], 1 + res[j]);
				}
			}
		}

		Arrays.sort(res);
		return res[res.length - 1];
	}
}
