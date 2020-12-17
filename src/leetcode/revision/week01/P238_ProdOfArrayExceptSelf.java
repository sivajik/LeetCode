package leetcode.revision.week01;

import java.util.Arrays;

public class P238_ProdOfArrayExceptSelf {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(productExceptSelf(new int[] { 1, 2, 3, 4 })));
	}

	static public int[] productExceptSelf(int[] nums) {
		int[] left = new int[nums.length];
		int[] rite = new int[nums.length];

		left[0] = 1;
		rite[rite.length - 1] = 1;

		for (int i = 1; i < nums.length; i++) {
			left[i] = left[i - 1] * nums[i - 1];
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			rite[i] = rite[i + 1] * nums[i + 1];
		}

		int[] res = new int[nums.length];

		for (int i = 0; i < res.length; i++) {
			res[i] = left[i] * rite[i];
		}
		return res;
	}
}
