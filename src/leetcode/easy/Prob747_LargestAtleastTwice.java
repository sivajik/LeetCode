package leetcode.easy;

public class Prob747_LargestAtleastTwice {

	public static void main(String[] args) {
		// System.out.println(dominantIndex(new int[] { 3, 6, 1, 0 }));
		// System.out.println(dominantIndex(new int[] { 1, 2, 3, 4 }));
		System.out.println(dominantIndex(new int[] { 1 }));
	}

	public static int dominantIndex(int[] nums) {
		int big = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] > big) {
				big = nums[i];
				index = i;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != big && nums[i] * 2 > big) {
				return -1;
			}
		}
		return index;
	}
}
