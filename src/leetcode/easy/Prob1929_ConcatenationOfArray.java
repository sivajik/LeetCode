package leetcode.easy;

import java.util.Arrays;

public class Prob1929_ConcatenationOfArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(getConcatenation(new int[] { 1, 2, 1 })));
		System.out.println(Arrays.toString(getConcatenation(new int[] { 1, 3, 2, 1 })));
	}

	static public int[] getConcatenation(int[] nums) {
		int len = nums.length;
		int[] op = new int[len * 2];
		for (int i = 0; i < len; i++) {
			op[i] = nums[i];
			op[i + len] = nums[i];
		}
		return op;
	}
}
