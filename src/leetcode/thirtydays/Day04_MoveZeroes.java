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

	// useless approach - 2 pointers.
	public static void moveZeroesComplex(int[] nums) {
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
	
	public static void moveZeroes(int[] nums) {
		int c = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[c++] = nums[i];
			}
		}
		
		for (int j = c; j < nums.length; j++) {
			nums[j] = 0;
		}
		System.out.println(Arrays.toString(nums));
	}
}
