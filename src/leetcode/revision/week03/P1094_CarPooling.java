package leetcode.revision.week03;

import java.util.Map;
import java.util.TreeMap;

public class P1094_CarPooling {

	public static void main(String[] args) {
		System.out.println(carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 4) == false);
		System.out.println(carPooling(new int[][] { { 2, 1, 5 }, { 3, 3, 7 } }, 5) == true);
		System.out.println(carPooling(new int[][] { { 2, 1, 5 }, { 3, 5, 7 } }, 3) == true);
		System.out.println(carPooling(new int[][] { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 } }, 11) == true);
	}

	static public boolean carPooling(int[][] trips, int capacity) {
		Map<Integer, Integer> map = new TreeMap<>();

		for (int[] eachTrip : trips) {
			int cap = eachTrip[0];
			int start = eachTrip[1];
			int end = eachTrip[2];

			int startCap = map.getOrDefault(start, 0) + cap;
			map.put(start, startCap);

			int endCap = map.getOrDefault(end, 0) - cap;
			map.put(end, endCap);
		}
		int currCap = 0;
		for (Integer i : map.values()) {
			currCap += i;
			if (currCap > capacity) {
				return false;
			}
		}

		return true;
	}
}
