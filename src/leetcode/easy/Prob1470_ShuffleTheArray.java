package leetcode.easy;

import java.util.Arrays;

public class Prob1470_ShuffleTheArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(shuffle(new int[] { 2, 5, 1, 3, 4, 7 }, 3)));
		System.out.println(Arrays.toString(shuffle(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }, 4)));
		System.out.println(Arrays.toString(shuffle(new int[] { 1, 1, 2, 2 }, 2)));
	}

	static public int[] shuffle(int[] nums, int n) {
		if (nums.length != 2 *n) {
			System.out.println("Error inputs...");
			return null;
		}
		
		int[] newArr = new int[nums.length];

		int i = 0;
		int j = n;
		int c = 0;
		while (i < n && j < 2 * n) {
			newArr[c++] = nums[i++];
			newArr[c++] = nums[j++];
		}
		return newArr;
	}
}