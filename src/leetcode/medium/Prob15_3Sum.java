package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prob15_3Sum {

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
		Set<Integer> seen = new HashSet<>();
		for (int j = i + 1; j < nums.length; j++) {
			int expected = -(nums[i] + nums[j]);
			if (seen.contains(expected)) {
				res.add(Arrays.asList(new Integer(nums[i]), new Integer(nums[j]), new Integer(expected)));
				while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
					j++;
				}
			}
			seen.add(nums[j]);
		}
	}
}
