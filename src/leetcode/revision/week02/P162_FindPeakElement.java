package leetcode.revision.week02;

public class P162_FindPeakElement {

	public static void main(String[] args) {
		// System.out.println(findPeakElement1(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
		System.out.println(findPeakElement1(new int[] { 3, 4, 3, 2, 1 }));
		System.out.println(findPeakElement1(new int[] { 5, 1, 2, 3, 4 }));
	}

	static public int findPeakElement1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		if (nums.length == 1) {
			return 0;
		}

		if (nums.length == 2) {
			if (nums[0] > nums[1]) {
				return 0;
			} else {
				return 1;
			}
		}

		int l = 0;
		int h = nums.length - 1;
		while (l <= h) {
			if (l + 1 == h) {
				return nums[l] > nums[h] ? l : h;
			}

			int mid = l + (h - l) / 2;

			if (mid > 0 && mid < nums.length - 1) {
				if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
					return mid;// THE mid element is bigger than both sides.
				} else if (nums[mid] > nums[mid - 1]) {
					// only mid is bigger than left, smaller than right so move forward
					l = mid + 1;
				} else {
					h = mid - 1;
				}

			} else {
				if (mid == 0) {
					if (nums[mid] > nums[mid + 1]) {
						return mid;
					}
				}

				if (mid == nums.length - 1) {
					if (nums[mid] > nums[mid - 1]) {
						return mid;
					}
				}
			}
		}
		return -1;
	}

	// Kevin.
	static public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			// assume mid is where peak element is, i.e higher than left and right elements.

			// if mid is still less than next one so it cant be peak so move forward.
			if (nums[mid] < nums[mid + 1]) {
				left = mid + 1;
			} else {
				right = mid; // we return left, hence no mid-1
			}
		}
		// return left pointer;
		return left;
	}
}
