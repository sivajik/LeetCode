package leetcode.thirtydays.april;

public class Day19_SearchInSrotedArray {

	public static void main(String[] args) {
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 100));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 4));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 2));
	}

	public static int search(int[] nums, int target) {
		if (nums.length == 0) {
			return -1;
		}

		int left = 0;
		int right = nums.length - 1;
		// 4,5,6,7,0,1,2
		// 0
		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target <= nums[right] && target > nums[mid]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}

		return -1;
	}
}
