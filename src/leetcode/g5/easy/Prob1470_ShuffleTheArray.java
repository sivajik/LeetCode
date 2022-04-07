package leetcode.g5.easy;

import java.util.Arrays;

public class Prob1470_ShuffleTheArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(shuffle(new int[] { 2, 5, 1, 3, 4, 7 }, 3)));
		System.out.println(Arrays.toString(shuffle(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }, 4)));
		System.out.println(Arrays.toString(shuffle(new int[] { 1, 1, 2, 2 }, 2)));
	}

	public static int[] shuffle(int[] nums, int n) {
		int[] res = new int[nums.length];
		int c = 0;
		for (int i = 0; i < n; i++) {
			res[c++] = nums[i];
			res[c++] = nums[i + n];
		}
		return res;
	}
}
