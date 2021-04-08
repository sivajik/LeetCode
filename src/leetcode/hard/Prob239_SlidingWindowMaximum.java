package leetcode.hard;

import java.util.Arrays;

public class Prob239_SlidingWindowMaximum {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1 }, 1)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 1, -1 }, 1)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 9, 11 }, 2)));
		System.out.println(Arrays.toString(maxSlidingWindow(new int[] { 4, -2 }, 2)));
	}

	static public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		if (n * k == 0) {
			return new int[0];
		}

		if (k == 1) {
			return nums;
		}

		int[] left = new int[nums.length];
		int[] rite = new int[nums.length];

		left[0] = nums[0];
		rite[n - 1] = nums[n - 1];

		for (int i = 1; i < n; i++) {
			if (i % k == 0) {
				left[i] = nums[i];
			} else {
				left[i] = Math.max(nums[i], left[i - 1]);
			}

			int j = n - i - 1;
			if ((j + 1) % k == 0) {
				rite[j] = nums[j]; // block_end
			} else {
				rite[j] = Math.max(rite[j + 1], nums[j]);
			}
		}

		int[] op = new int[n - k + 1];
		for (int i = 0; i < op.length; i++) {
			op[i] = Math.max(left[i + k - 1], rite[i]);
		}
		return op;
	}
}
