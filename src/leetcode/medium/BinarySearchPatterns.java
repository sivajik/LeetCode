package leetcode.medium;

public class BinarySearchPatterns {

	public static void main(String[] args) {
		for (int i = 0; i <= 9; i++) {
			System.out.println(binarySearch(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, i));
		}
	}

	static int binarySearch(int[] nums, int val) {
		int left = 0, right = nums.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (condition(nums[mid], val)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	private static boolean condition(int midVal, int val) {
		return midVal >= val;
	}

}
