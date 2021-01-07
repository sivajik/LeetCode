package leetcode.revision.week04;

public class P153_FindMinimuminRotatedSortedArray {

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(findMin(new int[] { 11, 13, 15, 17 }));
		System.out.println(findMin(new int[] { 3, 1, 2 }));

	}

	static public int findMin(int[] nums) {
		int l = 0;
		int h = nums.length - 1;

		while (l < h) {
			int mid = l + (h - l) / 2;
			if (nums[mid] > nums[h]) {
				l = mid + 1;
			} else {
				h = mid;
			}
		}
		return nums[l];
	}
}
