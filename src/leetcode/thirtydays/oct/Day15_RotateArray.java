package leetcode.thirtydays.oct;

import java.util.Arrays;

public class Day15_RotateArray {

	public static void main(String[] args) {
		int[] a = new int[] {1,2,3,4,5,6,7};
		rotate(a, 3);
		System.out.println(Arrays.toString(a));
	}

	static public void rotate(int[] nums, int k) {

		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);

	}

	static private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
			i++;
			j--;
		}
	}
}
