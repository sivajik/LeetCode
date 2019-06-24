package leetcode.easy;

import java.util.Arrays;

public class Probl001_TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[] {3, 2, 4};//{ 2, 7, 11, 15 };
		int[] results = twoSum(nums, 6);
		System.out.println(Arrays.toString(results));
		
		nums = new int[] { 2, 7, 11, 15 };
		results = twoSum(nums, 9);
		System.out.println(Arrays.toString(results));
	}

	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int currNum = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j};	
				}
			}
		}
		return null;
	}

	static int binSearch(int[] nums, int lookFor) {
		int lo = 0;
		int hi = nums.length - 1;

		while (lo <= hi) {
			int mid = lo + ((hi - lo) / 2);
			if (nums[mid] == lookFor) {
				return mid;
			} else if (nums[mid] < lookFor) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return -1;
	}
}
