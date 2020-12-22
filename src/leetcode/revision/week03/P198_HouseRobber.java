package leetcode.revision.week03;

public class P198_HouseRobber {

	public static void main(String[] args) {
		System.out.println(rob(new int[] { 1, 2, 3, 1 }));
	}

	static public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		if (nums.length == 1) {
			return nums[0];
		} else if (nums.length == 2) {
			return Math.max(nums[1], nums[0]);
		} else {
			int[] dp = new int[nums.length + 1];
			dp[0] = nums[0];
			dp[1] = Math.max(nums[0], nums[1]);
			for (int i = 2; i < nums.length; i++) {
				dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
			}
			return dp[nums.length - 1];
		}
	}
}
