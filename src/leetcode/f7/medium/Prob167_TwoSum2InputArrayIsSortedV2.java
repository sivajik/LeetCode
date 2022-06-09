package leetcode.f7.medium;

import java.util.Arrays;

public class Prob167_TwoSum2InputArrayIsSortedV2 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] { 5, 25, 75 }, 100)));
	}

	public static int[] twoSum(int[] numbers, int target) {
		int l = 0;
		int h = numbers.length - 1;

		while (l < h) {
			int sum = numbers[l] + numbers[h];
			if (sum == target) {
				return new int[] { l + 1, h + 1 };
			}
			if (sum < target) {
				l++;
			} else {
				h--;
			}
		}
		return null;
	}

}
