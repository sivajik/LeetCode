package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob39_CombinationSum {

	public static void main(String[] args) {
		for (List<Integer> eachList : combinationSum(new int[] { 2, 3, 6, 7 }, 7)) {
			System.out.println(eachList);
		}

	}

	static public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();

		solver(candidates, 0, target, result, new ArrayList<>());

		return result;
	}

	private static void solver(int[] candidates, int startIndex, int target, List<List<Integer>> result,
			List<Integer> tempList) {
		if (target == 0) {
			result.add(new ArrayList<>(tempList)); // don't add tempList directly as its tend to change
			return;
		}

		for (int i = startIndex; i < candidates.length; i++) {
			if (candidates[i] <= target) {
				tempList.add(candidates[i]);
				solver(candidates, i, target - candidates[i], result, tempList);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
