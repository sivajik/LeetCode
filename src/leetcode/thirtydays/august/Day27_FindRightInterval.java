package leetcode.thirtydays.august;

import java.util.Arrays;
import java.util.TreeMap;

public class Day27_FindRightInterval {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findRightInterval(new int[][] { { 1, 2 } })));
		System.out.println(Arrays.toString(findRightInterval(new int[][] { { 3, 4 }, { 2, 3 }, { 1, 2 } })));
		System.out.println(Arrays.toString(findRightInterval(new int[][] { { 1, 4 }, { 2, 3 }, { 3, 4 } })));

	}

	static public int[] findRightInterval(int[][] intervals) {
		if (intervals.length == 0) {
			return new int[] {};
		}
		if (intervals.length == 1) {
			return new int[] { -1 };
		}

		int[] result = new int[intervals.length];
		int counter = 0;

		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int[] eachElem : intervals) {
			map.put(eachElem[0], counter++);
		}
		counter = 0;
		for (int[] eachElem : intervals) {
			int currElemEndIndex = eachElem[1];
			Integer key = map.ceilingKey(currElemEndIndex);
			if (key == null) {
				result[counter++] = -1;
			} else {
				result[counter++] = map.get(key);
			}
		}
		return result;
	}

}
