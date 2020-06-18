package leetcode.medium;

public class Prob153_FindMinInRotatedSortedArr {

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(findMin(new int[] { 4, 5, 6, 7, 8, 9, 10, 2 }));
		System.out.println(findMin(new int[] { 3, 1, 2 }));
	}

	// 4,5,6,'7',0,1,2
	// 3,4,'5',1,2
	static public int findMin(int[] nums) {
		int low = 0;
		int high = nums.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] > nums[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return nums[low];
	}
}
