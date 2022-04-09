package leetcode.g5.easy;

import java.util.Arrays;

public class Prob1920_BuildArrayFromPermutation {

	public static void main(String[] args) {
		// System.out.println(Arrays.toString(buildArray(new int[] { 0, 2, 1, 5, 3, 4 })));
		System.out.println(Arrays.toString(buildArray(new int[] { 5, 0, 1, 2, 3, 4 })));
	}

	static public int[] buildArray(int[] nums) {
		/*
		 * to keep 2 values at same index:
		 * 
		 * a = a + b * n
		 * 
		 * to get a -> use a%n
		 * to get b -> use a/n
		 */
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] + (nums[nums[i]] % nums.length)*( nums.length);
		}
		System.out.println(Arrays.toString(nums));
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] / nums.length;
		}
		return nums;
	}
}