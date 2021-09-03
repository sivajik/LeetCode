package leetcode.easy;

import java.util.Arrays;

public class Prob645_SetMismatch {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findErrorNums(new int[] { 4, 2, 1, 2 })));
		System.out.println(Arrays.toString(findErrorNums(new int[] { 1,1 })));
	}

	static public int[] findErrorNums(int[] nums) {
		int twice = -1;
		int missing = -1;

		int[] counts = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (counts[num - 1] == 0) {
				counts[num - 1] = counts[num - 1] + 1;
			} else {
				// found duplicate.
				twice = num;
				System.out.println(num);
			}

		}

		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == 0) {
				System.out.println(i+1);
				missing = i+1;
				break;
			}
		}
		return new int[] { twice, missing };
	}
}
