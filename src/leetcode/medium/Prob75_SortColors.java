package leetcode.medium;

import java.util.Arrays;

public class Prob75_SortColors {

	public static void main(String[] args) {
		sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
		sortColors(new int[] { 2, 0, 2, 2, 0, 2 });
		sortColors(new int[] { 0, 0, 0, 0, 0 });
		sortColors(new int[] { 1 });
		sortColors(new int[] { 2, 0, 2, 1, 1, 0, 0, 1, 2, 0, 1, 2 });
	}

	static public void sortColors(int[] nums) {
		int low = 0, mid = 0, high = nums.length - 1;

		while (mid <= high) {
			if (nums[mid] == 0) {
				swap(nums, low, mid);
				low++;
				mid++;
			} else if (nums[mid] == 1) {
				mid++;
			} else if (nums[mid] == 2) {
				swap(nums, mid, high);
				high--;
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	static public void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
