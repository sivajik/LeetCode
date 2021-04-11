package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Prob523_ContinuousSubarraySum {

	public static void main(String[] args) {
		System.out.println(checkSubarraySum(new int[] { 23, 2, 4, 6, 6 }, 7));
		// System.out.println(checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 13));
	}

	static public boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		map.put(0,  -1);// without this when we get sum as zero code goes to false.
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k != 0) {
				sum = sum % k;
			}

			if (map.containsKey(sum)) {
				if (i - map.get(sum) > 1) {
					return true;
				}
			} else {
				map.put(sum, i);
			}
		}
		return false;
	}
}
