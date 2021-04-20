package leetcode.medium;

import java.util.Arrays;

public class Prob31_NextPermutation {

	public static void main(String[] args) {
		int[] a = new int[] { 8,7,9,5 };
		nextPermutation(a);
		System.out.println(Arrays.toString(a));
	}

	static public void nextPermutation(int[] nums) {
		// find first element in decreasing order.

		int i = nums.length - 2; // you check i, i+1
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		if (i >= 0) {
			// find j where a[j] is just bigger than a[i]
			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}

		reverse(nums, i + 1);
	}

	static private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	static private void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}
}
