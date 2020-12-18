package leetcode.revision.week02;

public class P33_SearchInRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
		System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
		System.out.println(search(new int[] { 1 }, 0));
	}

	static public int search(int[] nums, int target) {
		int minElemIndex = minElemAt(nums);
		System.out.println("Min ele: " + minElemIndex);
		int leftSearch = bs(nums, 0, minElemIndex - 1, target);
		if (leftSearch != -1) {
			return leftSearch;
		}
		return bs(nums, minElemIndex, nums.length - 1, target);
	}

	private static int minElemAt(int[] nums) {
		int l = 0;
		int h = nums.length - 1;
		int n = nums.length + 1;
		while (l <= h) {
			if (nums[l] <= nums[h]) {
				return l;
			}

			int mid = l + ((h - l) / 2);
			int prev = (mid - 1 + n) % n;
			int next = (mid + 1) % n;

			if (nums[mid] <= nums[next] && nums[mid] <= nums[prev]) {
				return mid;
			} else if (nums[l] <= nums[mid]) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}

		return -1;
	}

	private static int bs(int[] nums, int l, int h, int target) {
		while (l <= h) {
			int mid = l + (h - l) / 2;

			if (nums[mid] == target) {
				return mid;
			} else if (target > nums[mid]) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return -1;
	}
}
