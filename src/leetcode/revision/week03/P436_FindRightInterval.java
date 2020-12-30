package leetcode.revision.week03;

import java.util.Arrays;
import java.util.TreeMap;

public class P436_FindRightInterval {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findRightInterval(new int[][] { { 1, 2 } })));
		System.out.println(Arrays.toString(findRightInterval(new int[][] { { 3, 4 }, { 2, 3 }, { 1, 2 } })));
		System.out.println(Arrays.toString(findRightInterval(new int[][] { { 1, 4 }, { 2, 3 }, { 3, 4 } })));

	}

	static public int[] findRightInterval(int[][] intervals) {
		if (intervals == null || intervals.length == 0) {
			return new int[] {};
		}

		if (intervals.length == 1) {
			return new int[] { -1 };
		}

		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < intervals.length; i++) {
			int[] eachInterval = intervals[i];
			map.put(eachInterval[0], i);
		}

		int[] res = new int[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			int[] eachInter = intervals[i];
			if (map.ceilingKey(eachInter[1]) != null) {
				res[i] = map.get(map.ceilingKey(eachInter[1]));
			} else {
				res[i] = -1;
			}
		}
		return res;
	}
}
