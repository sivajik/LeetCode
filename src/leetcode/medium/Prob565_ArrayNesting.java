package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Prob565_ArrayNesting {

	public static void main(String[] args) {
		System.out.println(arrayNesting(new int[] { 5, 4, 0, 3, 1, 6, 2 }));
		System.out.println(arrayNesting(new int[] { 0, 1, 2 }));
		System.out.println(arrayNesting(new int[] { 15 }));
	}

	static public int arrayNesting(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int res = Integer.MIN_VALUE;

		boolean[] visited = new boolean[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int len = util(nums, i, visited, new HashSet<>());
			if (len > res) {
				res = len;
			}
		}
		return res;
	}

	private static int util(int[] nums, int index, boolean[] visited, Set<Integer> set) {
		if (index >= nums.length) {
			return set.size();
		}

		if (visited[index] == true) {
			return set.size();
		}

		visited[index] = true;
		set.add(nums[index]);
		return util(nums, nums[index], visited, set);
	}
}
