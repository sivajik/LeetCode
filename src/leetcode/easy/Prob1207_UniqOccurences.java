package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Prob1207_UniqOccurences {

	public static void main(String[] args) {
		System.out.println(uniqueOccurrences(new int[] { 1, 2, 2, 1, 1, 3 }));
		System.out.println(uniqueOccurrences(new int[] { 1, 2 }));
		System.out.println(uniqueOccurrences(new int[] { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 }));

	}

	public static boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int elem : arr) {
			if (map.containsKey(elem)) {
				map.put(elem, 1 + map.get(elem));
			} else {
				map.put(elem, 1);
			}
		}
		int preSize = map.values().size();
		int afterSize = (int) map.values().parallelStream().distinct().count();
		return preSize == afterSize;
	}
}
