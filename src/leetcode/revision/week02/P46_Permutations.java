package leetcode.revision.week02;

import java.util.*;

public class P46_Permutations {

	public static void main(String[] args) {
		for (List<Integer> l : permute(new int[] { 1, 2, 3 })) {
			System.out.println(l);
		}
	}

	static public List<List<Integer>> permute(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		List<List<Integer>> l = new ArrayList<>();
		solve(nums, 0, l);
		return l;
	}

	private static void solve(int[] nums, int currIndex, List<List<Integer>> l) {
		if (currIndex == nums.length) {
			List<Integer> temp = new ArrayList<>();
			for (int n : nums) {
				temp.add(n);
			}
			l.add(temp);
			return; // the most imp step
		}
		for (int i = currIndex; i < nums.length; i++) {
			swap(nums, currIndex, i);
			solve(nums, currIndex + 1, l);
			swap(nums, currIndex, i);
		}
	}

	static private void swap(int[] nums, int i, int j) {
		int a = nums[i];
		nums[i] = nums[j];
		nums[j] = a;
	}
}
