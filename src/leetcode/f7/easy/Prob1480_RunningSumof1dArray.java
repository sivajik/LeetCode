package leetcode.f7.easy;

import java.util.Arrays;

public class Prob1480_RunningSumof1dArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(runningSum(new int[] { 1, 2, 3, 4 })));

	}

	static public int[] runningSum(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i - 1];
		}
		return nums;
	}
}
