package leetcode.hard;

public class Prob154_FindMinInRotatedArray2 {
	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(findMin(new int[] { 4, 5, 6, 7, 8, 9, 10, 2 }));
		System.out.println(findMin(new int[] { 3, 1, 2 }));
	}

	static public int findMin(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			if (nums[mid] > nums[hi]) {
				lo = mid + 1;
			} else if (nums[mid] < nums[hi]) {
				hi = mid;
			} else { // nums[mid] ==  nums[hi]
				hi--;
			}
		}
		return nums[lo];
	}
}
