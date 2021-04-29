package leetcode.easy;

import java.util.Arrays;

public class Prob628_MaximumProductofThreeNumbers {

	public static void main(String[] args) {
		System.out.println(maximumProduct(new int[] { 1, 2, 3 }));
		System.out.println(maximumProduct(new int[] { 1, 2, 3, 4 }));
		System.out.println(maximumProduct(new int[] { -1, -2, -3 }));
	}

	static public int maximumProduct(int[] nums) {
		Arrays.sort(nums);
		return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
				nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
	}
}
