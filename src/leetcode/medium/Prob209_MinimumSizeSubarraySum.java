package leetcode.medium;

public class Prob209_MinimumSizeSubarraySum {

	public static void main(String[] args) {
		System.out.println(minSubArrayLen(7, new int[] { 2, 3, 1, 3, 4, 3 }));

	}

	static public int minSubArrayLen(int target, int[] nums) {
		int sum = 0;
		int left = 0;
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= target) {
				ans = Math.min(ans, i + 1 - left);
				sum = sum - nums[left++];
			}
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;
	}
}
