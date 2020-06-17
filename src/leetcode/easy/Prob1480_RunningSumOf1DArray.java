package leetcode.easy;

import java.util.Arrays;

public class Prob1480_RunningSumOf1DArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(runningSum(new int[] { 1, 2, 3, 4 })));
		System.out.println(Arrays.toString(runningSum(new int[] { 1, 1, 1, 1, 1 })));
		System.out.println(Arrays.toString(runningSum(new int[] { 3, 1, 2, 10, 1 })));
	}

	static public int[] runningSum(int[] nums) {
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			nums[i] = sum + nums[i];
			sum = nums[i];
		}
		return nums;
	}
}
