package leetcode.f7.easy;

import java.util.Arrays;

public class Prob1920_BuildArrayFromPermutation {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(buildArray(new int[] { 0, 2, 1, 5, 3, 4 })));

	}

	static public int[] buildArray(int[] nums) {
		int[] op = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			op[i] = nums[nums[i]];
		}
		return op;
	}
}
