package leetcode.g5.easy;

import java.util.Arrays;

public class Prob977_SquaresofaSortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
		System.out.println(Arrays.toString(sortedSquares(new int[] { -7, -3, 2, 3, 11 })));
		System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 2, 3 }))); // 0 1 2 3
		System.out.println(Arrays.toString(sortedSquares(new int[] { -7 })));
	}

	static public int[] sortedSquares(int[] nums) {
		int[] sorted = new int[nums.length];

		int l = 0;
		int r = nums.length - 1;
		
		// first fish for bigger numbers and put them at the end.
		for (int i = nums.length - 1; i >= 0; i--) {
			int num;
			if (Math.abs(nums[l]) < Math.abs(nums[r])) {
				num = Math.abs(nums[r]);
				r--;
			} else {
				num = Math.abs(nums[l]);
				l++;
			}
			sorted[i] = num * num;
		}
		return sorted;
	}
}
