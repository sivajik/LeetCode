package leetcode.revision.week03;

import java.util.*;

public class P39_CombinationSum {

	public static void main(String[] args) {
		for (List<Integer> l : combinationSum(new int[] { 2, 3, 6, 7 }, 7)) {
			System.out.println(l);
		}
		System.out.println();

		for (List<Integer> l : combinationSum(new int[] { 2, 3, 5 }, 8)) {
			System.out.println(l);
		}
		System.out.println();

		for (List<Integer> l : combinationSum(new int[] { 2 }, 1)) {
			System.out.println(l);
		}
		System.out.println();

		for (List<Integer> l : combinationSum(new int[] { 1 }, 1)) {
			System.out.println(l);
		}
		System.out.println();

		for (List<Integer> l : combinationSum(new int[] { 1 }, 2)) {
			System.out.println(l);
		}
		System.out.println();
	}

	static public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> l = new ArrayList<>();
		solve(candidates, /**/0, target, l, new ArrayList<Integer>());
		return l;
	}

	static private void solve(int[] candidates, int currIndex, int target, List<List<Integer>> l, List<Integer> tmp) {
		if (target == 0) {
			l.add(new ArrayList<Integer>(tmp));
			return;
		}

		for (int i = currIndex; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				tmp.add(candidates[i]);
				solve(candidates, i, target - candidates[i], l, tmp);
				tmp.remove(tmp.size() - 1);
			}
		}
	}

}
