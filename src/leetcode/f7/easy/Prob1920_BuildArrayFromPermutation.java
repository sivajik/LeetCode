package leetcode.f7.easy;

import java.util.Arrays;

public class Prob1920_BuildArrayFromPermutation {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(buildArray(new int[] { 0, 2, 1, 5, 3, 4 })));

	}

	static public int[] buildArray1(int[] nums) {
		int[] op = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			op[i] = nums[nums[i]];
		}
		return op;
	}

	// each number keep this number and other number in same place...
	// say for number a keep a and a + b * n; then we can do a%n for first number,
	// a/n for second
	// number
	static public int[] buildArray(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] + (nums.length * (nums[nums[i]] % nums.length));
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] / nums.length;
		}
		return nums;
	}
}
