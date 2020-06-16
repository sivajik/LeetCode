package leetcode.medium;

public class Prob300_DP_LIS {

	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));

	}

	static public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int[] res = new int[nums.length];
		java.util.Arrays.fill(res, 1);

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					res[i] = Math.max(res[i], res[j] + 1);
				}
			}
		}

		java.util.Arrays.sort(res);
		return res[res.length - 1];
	}
}
