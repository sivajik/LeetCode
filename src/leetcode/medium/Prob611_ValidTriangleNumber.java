package leetcode.medium;

import java.util.Arrays;

public class Prob611_ValidTriangleNumber {

	public static void main(String[] args) {
		System.out.println(triangleNumber(new int[] { 2, 2, 3, 4 }));

	}

	static public int triangleNumber(int[] nums) {
		int count = 0;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int k = i + 2;
			for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
				k = binsearch(nums, k, nums.length - 1, nums[i] + nums[j]);
				// System.out.println(nums[i] + "," + nums[j] + "," + nums[k]);
				System.out.println(i + "," + j + "," + k);
				count += (k - j - 1);
			}
		}

		return count;
	}

	private static int binsearch(int[] nums, int l, int r, int value) {
		while (l <= r && r < nums.length) {
			int mid = l + (r - l) / 2;
			if (nums[mid] >= value) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
}
