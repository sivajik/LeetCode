package leetcode.medium;

public class Prob152_MaximumProductSubarray {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(maxProduct(new int[] { -2, 0, -1 }));
	}

	static public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int localMax = nums[0];
		int localMin = nums[0];
		int globalMax = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int temp = localMax;

			localMax = Math.max(nums[i], Math.max(localMax * nums[i], localMin * nums[i]));
			localMin = Math.max(nums[i], Math.max(temp * nums[i], localMin * nums[i]));

			if (localMax > globalMax) {
				globalMax = localMax;
			}
		}
		return globalMax;
	}
}
