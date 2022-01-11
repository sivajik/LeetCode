package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob1817FindingUsersActiveMinutes {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findingUsersActiveMinutes(new int[][] { { 1, 1 }, { 2, 2 }, { 2, 3 } }, 4)));
	}

	static public int[] findingUsersActiveMinutes(int[][] logs, int k) {
		int[] op = new int[k];
		Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();

		for (int[] log : logs) {
			if (map.containsKey(log[0])) {
				Set<Integer> s = map.get(log[0]);
				s.add(log[1]);
				map.put(log[0], s);
			} else {
				Set<Integer> s = new HashSet<>();
				s.add(log[1]);
				map.put(log[0], s);
			}
		}
		for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
			op[entry.getValue().size() - 1]++;
		}
		return op;
	}
}
