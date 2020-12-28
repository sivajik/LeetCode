package leetcode.revision.week03;

public class P152_MaximumProductSubarray {

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(maxProduct(new int[] { -2, 0, -1 }));
		System.out.println(maxProduct(new int[] { 2, -1, 1, 1 }));

	}

	static public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}

		int maxSoFar = nums[0];
		int minSoFar = nums[0];
		int res = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int curr = nums[i];
			int origMaxSoFar = maxSoFar;

			maxSoFar = max(curr, maxSoFar * curr, minSoFar * curr);
			minSoFar = min(curr, origMaxSoFar * curr, minSoFar * curr);

			res = Math.max(res, maxSoFar);
		}

		return res;
	}

	private static int min(int curr, int i, int j) {
		return Math.min(curr, Math.min(i, j));
	}

	private static int max(int curr, int i, int j) {
		return Math.max(curr, Math.max(i, j));
	}
}
