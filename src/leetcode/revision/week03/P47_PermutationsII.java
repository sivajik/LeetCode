package leetcode.revision.week03;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class P47_PermutationsII {

	public static void main(String[] args) {
		for (List<Integer> list : permuteUnique(new int[] { 1, 2, 3 })) {
			System.out.println(list);
		}
		System.out.println();
		for (List<Integer> list : permuteUnique(new int[] { 1, 1, 2 })) {
			System.out.println(list);
		}

	}

	static public List<List<Integer>> permuteUnique(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int n : nums) {
			if (map.containsKey(n)) {
				map.put(n, 1 + map.get(n));
			} else {
				map.put(n, 1);
			}
		}

		List<List<Integer>> result = new ArrayList<>();
		LinkedList<Integer> currComb = new LinkedList<>();
		helper(map, result, nums.length, currComb);
		return result;
	}

	private static void helper(Map<Integer, Integer> map, List<List<Integer>> l, int n, LinkedList<Integer> currComb) {
		if (currComb.size() == n) {
			l.add(new ArrayList<>(currComb));
			return;
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int num = entry.getKey();
			int count = entry.getValue();

			if (count == 0) {
				continue; // used all ocurrences
			}
			currComb.addLast(num);
			map.put(num, map.get(num) - 1);

			helper(map, l, n, currComb);

			currComb.removeLast();
			map.put(num, count);
		}

	}

}
