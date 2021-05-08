package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Prob760_FindAnagramMappings {

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(anagramMappings(new int[] { 12, 28, 46, 32, 50 }, new int[] { 50, 12, 32, 46, 28 })));
	}

	static public int[] anagramMappings(int[] A, int[] B) {
		int[] op = new int[A.length];

		Map<Integer, LinkedList<Integer>> map = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			if (map.containsKey(B[i])) {
				LinkedList<Integer> list = map.get(B[i]);
				list.add(i);
				map.put(B[i], list);
			} else {
				LinkedList<Integer> list = new LinkedList<>();
				list.add(i);
				map.put(B[i], list);
			}
		}

		for (int i = 0; i < A.length; i++) {
			List<Integer> list = map.get(A[i]);
			if (list.size() > 1) {
				op[i] = list.get(0);
				list.remove(0);
			} else if (list.size() == 1) {
				op[i] = list.get(0);
			}
		}

		return op;
	}
}

/*
 * 12 28 46 32 50 50 12 32 46 28
 */
