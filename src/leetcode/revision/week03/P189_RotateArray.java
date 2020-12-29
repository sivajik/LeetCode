package leetcode.revision.week03;

import java.util.Arrays;

public class P189_RotateArray {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums, 3);
		System.out.println(Arrays.toString(nums));
	}

	static public void rotate(int[] nums, int k) {
		k = k % nums.length;
		rot(nums, 0, nums.length - 1);
		rot(nums, 0, k - 1);
		rot(nums, k, nums.length - 1);
	}

	private static void rot(int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}

}
