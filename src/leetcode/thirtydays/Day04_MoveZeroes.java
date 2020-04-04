package leetcode.thirtydays;

import java.util.Arrays;

public class Day04_MoveZeroes {

	public static void main(String[] args) {
		moveZeroes(new int[] { 2, 1 });
		moveZeroes(new int[] { 9, 7, 0, 1, 0, 3, 12 });
		moveZeroes(new int[] { 9, 7, 0, 0, 0, 0, 0 });
		moveZeroes(new int[] { 0, 0, 0, 12, 14, 16, 0, 0, 0 });
		moveZeroes(new int[] { 0, 0, 0 });
	}

	public static void moveZeroes(int[] nums) {
		int slowPointer = 0;
		int fastPointer = slowPointer + 1;

		while (slowPointer < nums.length && fastPointer < nums.length) {
			while (slowPointer < nums.length && nums[slowPointer] != 0) {
				slowPointer++;
			}
			fastPointer = slowPointer + 1;

			while (fastPointer < nums.length && nums[fastPointer] == 0) {
				fastPointer++;
			}

			if (slowPointer < fastPointer && fastPointer < nums.length) {
				int temp = nums[slowPointer];
				nums[slowPointer] = nums[fastPointer];
				nums[fastPointer] = temp;
				slowPointer++;
			}
		}
		System.out.println(Arrays.toString(nums));
	}
}
