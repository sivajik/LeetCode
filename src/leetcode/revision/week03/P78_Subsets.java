package leetcode.revision.week03;

import java.util.*;

public class P78_Subsets {

	public static void main(String[] args) {
		for (List<Integer> l : subsets(new int[] { 1, 2, 3 })) {
			System.out.println(l);
		}
	}

	static public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> l = new ArrayList<>();

		helper(nums, 0, l, new int[nums.length]);
		return l;
	}

	private static void helper(int[] nums, int currIndex, List<List<Integer>> l, int[] bits) {
		if (currIndex == nums.length) {
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < bits.length; i++) {
				if (bits[i] == 1) {
					temp.add(nums[i]);
				}
			}
			l.add(temp);
			return;
		}

		bits[currIndex] = 0;
		helper(nums, currIndex + 1, l, bits);

		bits[currIndex] = 1;
		helper(nums, currIndex + 1, l, bits);
	}
}
