package leetcode.revision.week03;

public class P300_LongestIncreasingSequence {

	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		System.out.println(lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));
		System.out.println(lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 }));
	}

	static public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], 1 + dp[j]);
				}
			}
		}
		int res = Integer.MIN_VALUE;
		for (int n : dp) {
			res = Math.max(res, n);
		}
		return res;
	}
}
