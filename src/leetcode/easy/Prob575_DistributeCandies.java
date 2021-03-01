package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Prob575_DistributeCandies {

	public static void main(String[] args) {
		System.out.println(distributeCandies(new int[] { 1, 1, 2, 2, 3, 3 }));
		System.out.println(distributeCandies(new int[] { 1, 1, 2, 3 }));
		System.out.println(distributeCandies(new int[] { 6, 6, 6, 6 }));
	}

	static public int distributeCandies(int[] candyType) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int eachType : candyType) {
			map.putIfAbsent(eachType, map.getOrDefault(eachType, 0) + 1);
		}
		if (map.size() == candyType.length / 2) {
			return candyType.length / 2;
		} else if (map.size() > candyType.length / 2) {
			return candyType.length / 2;
		} else {
			return map.size();
		}
	}
}
