package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob1365_HowManySmaller {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[] { 8, 1, 2, 2, 3 })));
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[] { 6, 5, 4, 8 })));
		System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[] { 7, 7, 7, 7 })));
	}

	public static int[] smallerNumbersThanCurrent(int[] nums) {
		int[] orig = new int[nums.length];
		orig = Arrays.copyOf(nums, nums.length);

		Arrays.sort(nums);

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (! map.containsKey(nums[i])) {
				map.put(nums[i], i);
			}
		}

		int[] results = new int[nums.length];
		for (int i = 0; i < orig.length; i++) {
			results[i] = map.get(orig[i]);
		}

		return results;
	}
}