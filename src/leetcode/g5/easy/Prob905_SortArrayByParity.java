package leetcode.g5.easy;

import java.util.Arrays;

public class Prob905_SortArrayByParity {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortArrayByParity(new int[] { 3, 1, 2, 4 })));
		System.out.println(Arrays.toString(sortArrayByParity(new int[] { 0 })));
	}

	static public int[] sortArrayByParity(int[] nums) {
		if (nums.length == 1) {
			return nums;
		}

		int l = 0;
		int h = nums.length - 1;
		while (l <= h) {
			if (nums[l] % 2 == 0) {
				l++;
				continue;
			}
			if (nums[h] % 2 != 0) {
				h--;
				continue;
			}
			int temp = nums[l];
			nums[l] = nums[h];
			nums[h] = temp;
			l++;
			h--;
		}
		return nums;
	}
}
