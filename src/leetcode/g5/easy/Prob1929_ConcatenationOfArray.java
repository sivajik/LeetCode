package leetcode.g5.easy;

import java.util.Arrays;

public class Prob1929_ConcatenationOfArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(getConcatenation(new int[] { 1, 2, 1 })));
		System.out.println(Arrays.toString(getConcatenation(new int[] { 1, 3, 2, 1 })));
	}

	static public int[] getConcatenation(int[] nums) {
		int[] res = new int[nums.length * 2];
		int l = nums.length;
		for (int i = 0; i < l; i++) {
			res[i] = res[i + l] = nums[i];
		}
		return res;
	}
}
