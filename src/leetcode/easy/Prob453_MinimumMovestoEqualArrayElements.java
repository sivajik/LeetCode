package leetcode.easy;

import java.util.Arrays;

public class Prob453_MinimumMovestoEqualArrayElements {

	public static void main(String[] args) {
		System.out.println(minMoves(new int[] { 1, 2, 3 }));

	}

	static public int minMoves(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
		}
		int c = 0;
		for (int i = 0; i < nums.length; i++) {
			c += nums[i] - min;
		}
		return c;
	}

	static public int minMoves1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		Arrays.sort(nums);
		int c = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			c += nums[i] - nums[0];
		}
		return c;
	}
}
