package leetcode.revision.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob46_Permutations {

	public static void main(String[] args) {
		for (List<Integer> l : permute(new int[] { 1, 2, 3 })) {
			System.out.println(l);
		}

	}

	static public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		solve(nums, res, 0);
		return res;
	}

	private static void solve(int[] nums, List<List<Integer>> res, int currIndex) {
		if (currIndex == nums.length) {
			List<Integer> l = new ArrayList<>();
			for (int e : nums) {
				l.add(e);
			}
			res.add(l);
			return;
		}

		for (int x = currIndex; x < nums.length; x++) {
			swap(nums, x, currIndex);
			solve(nums, res, currIndex + 1);
			swap(nums, x, currIndex);
		}

	}

	private static void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}
