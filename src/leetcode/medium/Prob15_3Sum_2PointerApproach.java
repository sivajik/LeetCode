package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob15_3Sum_2PointerApproach {

	public static void main(String[] args) {
		for (List<Integer> l : threeSum(new int[] { -1, 0, 1, 2, -1, -4 })) {
			System.out.println(l);
		}
	}

	static public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				twosum(nums, i, res);
			}
		}
		return res;
	}

	private static void twosum(int[] nums, int i, List<List<Integer>> res) {
		int lo = i + 1, hi = nums.length - 1;
		while (lo < hi) {
			int sum = nums[i] + nums[lo] + nums[hi];
			if (sum == 0) {
				res.add(Arrays.asList(new Integer(nums[i]), new Integer(nums[lo]), new Integer(nums[hi])));
				lo++;
				hi--;
				while (lo < hi && nums[lo] == nums[lo - 1]) {
					lo++;
				}
			} else if (sum < 0) {
				lo++;
			} else if (sum > 0) {
				hi--;
			}
		}
	}
}
