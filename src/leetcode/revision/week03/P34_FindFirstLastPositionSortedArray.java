package leetcode.revision.week03;

import java.util.Arrays;

public class P34_FindFirstLastPositionSortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
		System.out.println(Arrays.toString(searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));
		System.out.println(Arrays.toString(searchRange(new int[] {}, 0)));
	}

	static public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[] { -1, -1 };
		}

		int left = leftScan(nums, target);
		int rite = rigteScan(nums, target);
		return new int[] { left, rite };
	}

	private static int rigteScan(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		int lastKnownPosition = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == target) {
				lastKnownPosition = mid;
				low = mid + 1;
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return lastKnownPosition;
	}

	private static int leftScan(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;

		int lastKnownPosition = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (nums[mid] == target) {
				lastKnownPosition = mid;
				high = mid - 1;
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return lastKnownPosition;
	}
}
