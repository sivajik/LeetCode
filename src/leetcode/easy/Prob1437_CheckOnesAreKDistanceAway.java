package leetcode.easy;

import java.util.Map;
import java.util.TreeMap;

public class Prob1437_CheckOnesAreKDistanceAway {

	public static void main(String[] args) {
		System.out.println(kLengthApart(new int[] { 1, 0, 0, 0, 1, 0, 0, 1 }, 2) == true);
		System.out.println(kLengthApart(new int[] { 1, 0, 0, 1, 0, 1 }, 2) == false);
		System.out.println(kLengthApart(new int[] { 1, 1, 1, 1, 1 }, 0) == true);
		System.out.println(kLengthApart(new int[] { 0, 1, 0, 1 }, 1) == true);
		System.out.println(kLengthApart(new int[] { 0, 0, 0 }, 2) == true);
	}

	static public boolean kLengthApart(int[] nums, int k) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				map.put(i, 1);
			}
		}
		if (map.isEmpty()) {
			return true;
		}
		int initPos = map.firstKey();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (initPos != entry.getKey()) {
				if (entry.getKey() - initPos <= k) {
					return false;
				} else {
					initPos = entry.getKey();
				}
			}
		}
		return true;
	}
}
