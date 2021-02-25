package leetcode.thirtydays.feb;

import java.util.Arrays;

public class P25_ShortestUnsortedConSubArray {

	public static void main(String[] args) {
		System.out.println(findUnsortedSubarray(new int[] { 2, 6, 4, 8, 10, 9, 15 }));
		System.out.println(findUnsortedSubarray(new int[] { 2, 3, 4 }));
		System.out.println(findUnsortedSubarray(new int[] { 2, 5, 3, 8 }));
		System.out.println(findUnsortedSubarray(new int[] { 2 }));
		System.out.println(findUnsortedSubarray(new int[] { 2, 1 }));
	}

	static public int findUnsortedSubarray(int[] nums) {
		int[] sorted = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sorted);

		int low = -1, high = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != sorted[i]) {
				if (low == -1) {
					low = i;
				} else {
					high = i;
				}
			}
		}
		return high - low == 0 ? 0 : high - low + 1;
	}
}
/*
 * 
 * 2, 6, 4, 8, 10, 9, 15 2, 4, 6, 8, 9,10, 15
 * 
 */