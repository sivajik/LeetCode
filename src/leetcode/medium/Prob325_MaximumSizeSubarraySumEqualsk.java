package leetcode.medium;

import java.util.HashMap;

public class Prob325_MaximumSizeSubarraySumEqualsk {

	public static void main(String[] args) {
		System.out.println(maxSubArrayLen(new int[] { 1, -1, 5, -2, 3 }, 3));
		System.out.println(maxSubArrayLen(new int[] { -2, -1, 2, 1 }, 1));
	}

	static public int maxSubArrayLen(int[] nums, int k) {
		int max = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum == k) {
				// we met the condition
				max = i + 1; // index starts with 0
			} else {
				if (map.containsKey(sum - k)) {
					max = Math.max(max, i - map.get(sum - k));
				}
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
		}
		return max;
	}
}
