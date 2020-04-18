package leetcode.medium;

import java.util.Arrays;

public class Prob0287_FindDuplicateNumber {

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
		System.out.println(findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
	}

	public static int findDuplicate(int[] nums) {
		Arrays.sort(nums);
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result = result ^ nums[i];
			if (result == 0) {
				return nums[i];
			} else {
				result = nums[i];
			}
		}
		return -1;
	}
}
