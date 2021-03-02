package leetcode.thirtydays.mar21;

import java.util.Arrays;

public class P02_SetMismatch {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findErrorNums(new int[] { 4, 2, 1, 2 })));
		System.out.println(Arrays.toString(findErrorNums(new int[] { 1, 1 })));
	}

	static public int[] findErrorNums(int[] nums) {
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				res[0] = (index + 1);
			} else {
				nums[index] = -1 * nums[index];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				res[1] = (i + 1);
			}
		}
		return res;

	}
}
