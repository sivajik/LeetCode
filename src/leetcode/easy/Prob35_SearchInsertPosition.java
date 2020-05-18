package leetcode.easy;

public class Prob35_SearchInsertPosition {

	public static void main(String[] args) {
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 5));
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 2));
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 7));
		System.out.println(searchInsert(new int[] { 1, 3, 5, 6 }, 0));
		System.out.println(searchInsert(new int[] { 1, 3 }, 3));
	}

	public static int searchInsert(int[] nums, int target) {
		if (nums.length == 0 || target <= nums[0]) {
			return 0;
		}

		if (target > nums[nums.length - 1]) {
			return nums.length;
		}
		if (target == nums[nums.length - 1]) {
			return nums.length - 1;
		}

		return binarySearch(nums, target);
	}

	private static int binarySearch(int[] nums, int target) {
		int l = 0;
		int h = nums.length - 1;
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (nums[m] == target) {
				return m;
			} else if (target < nums[m]) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		return l;
	}
}
