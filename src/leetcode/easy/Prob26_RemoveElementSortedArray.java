package leetcode.easy;

public class Prob26_RemoveElementSortedArray {

	public static void main(String[] args) {
		removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 });
		removeDuplicates(new int[] { 1, 1, 2 });
		removeDuplicates(new int[] { 1, 1, 1 });
		removeDuplicates(new int[] { 1 });
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		
		int prev = nums[0];
		int c = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == prev) {
				// do nothing. just move forward.
			} else {
				nums[c++] = nums[i];
				prev = nums[i];
			}
		}
		return c;
	}
}
