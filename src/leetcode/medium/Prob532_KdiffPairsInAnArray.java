package leetcode.medium;

import java.util.Arrays;

public class Prob532_KdiffPairsInAnArray {

	public static void main(String[] args) {
		System.out.println(findPairs(new int[] { 3, 1, 4, 1, 5 }, 2));
		System.out.println(findPairs(new int[] { 1, 2, 3, 4, 5 }, 1));
		System.out.println(findPairs(new int[] { 1, 3, 1, 5, 4 }, 0));
		System.out.println(findPairs(new int[] { 1, 2, 4, 4, 3, 3, 0, 9, 2, 3 }, 3));
		System.out.println(findPairs(new int[] { -1, -2, -3 }, 1));
	}

	static public int findPairs(int[] nums, int k) {
		int left = 0;
		int right = 1;
		int cnt = 0;
		Arrays.sort(nums);
		// 1 1 3 4 5
		while (left < nums.length && right < nums.length) {
			if (left == right || nums[right] - nums[left] < k) {
				right++;
			} else if (nums[right] - nums[left] > k) {
				left++;
			} else { // == k
				left++;
				cnt++;
				while (left < nums.length && left > 0 && nums[left] == nums[left - 1]) {
					left++;
				}
			}
		}
		return cnt;
	}
}
