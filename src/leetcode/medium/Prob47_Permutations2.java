package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob47_Permutations2 {

	public static void main(String[] args) {
		for (List<Integer> eachList : permute(new int[] { 1, 2, 3 })) {
			System.out.println(eachList);
		}

	}

	static public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		solve(nums, /* startIndex= */0, result);
		return result;
	}

	private static void solve(int[] nums, int start, List<List<Integer>> result) {
		if (start == nums.length) {
			List<Integer> tempList = new ArrayList<>();
			for (int n : nums) {
				tempList.add(n);
			}
			result.add(tempList);
			return;
		}
		for (int i = start; i < nums.length; i++) {
			swap(nums, start, i);
			solve(nums, start + 1, result);
			swap(nums, start, i);
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int a = nums[i];
		nums[i] = nums[j];
		nums[j] = a;
	}
}
