package leetcode.easy;

import java.util.Arrays;

public class Prob1920_BuildArrayFromPermutation {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(buildArray(new int[] { 5, 0, 1, 2, 3, 4 })));

	}

	static public int[] buildArray(int[] nums) {
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			res[i] = nums[nums[i]];
		}
		return res;
	}
}
