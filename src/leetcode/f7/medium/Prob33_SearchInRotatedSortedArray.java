package leetcode.f7.medium;

public class Prob33_SearchInRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
		System.out.println(search(new int[] { 4,5,6,7,0,1,2 }, 3));
		System.out.println(search(new int[] { 1 }, 0));
	}

	static public int search(int[] nums, int target) {
		int l = 0;
		int h = nums.length - 1;
		while (l <= h) {
			int mid = l + (h - l) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (nums[l] <= nums[mid]) { // first half increasing.
				if (target >= nums[l] && target <= nums[mid]) { // does number falls here?
					h = mid - 1;
				} else {
					l = mid + 1;
				}
			} else { // first half decreasing.
				if (target >= nums[mid] && target <= nums[h]) { // does num falls here?
					l = mid + 1;
				} else {
					h = mid - 1;
				}
			}
		}
		return -1;
	}
}
