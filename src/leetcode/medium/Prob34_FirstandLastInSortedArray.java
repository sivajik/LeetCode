package leetcode.medium;

import java.util.Arrays;

public class Prob34_FirstandLastInSortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] {  }, 5)));
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 5, 5, 5, 5, 5, 5 }, 5)));
	}

	static public int[] searchRange(int[] nums, int target) {
		int[] op = new int[] { -1, -1 };

		op[0] = leftFind(nums, target);
		op[1] = riteFind(nums, target);
		return op;
	}

	private static int riteFind(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int lastFound = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				lastFound = mid;
				left = mid + 1; // you are interested to see right extreme, so move right. 
			}
		}
		return lastFound;

	}

	// 0 1 2 3 4 4 4 4 4 4 '5' 5 5 9
	private static int leftFind(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int lastFound = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] > target) {
				right = mid - 1;
			} else {
				lastFound = mid;
				right = mid - 1; // you are interested to see right extreme, so move right
			}
		}
		return lastFound;
	}
}