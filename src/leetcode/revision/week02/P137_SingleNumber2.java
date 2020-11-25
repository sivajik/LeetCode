package leetcode.revision.week02;

import java.util.*;

public class P137_SingleNumber2 {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 2, 2, 3, 2 }));
		System.out.println(singleNumber(new int[] { 0, 1, 0, 1, 0, 1, 99 }));
	}

	static public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (Integer i : map.keySet()) {
			if (map.get(i) == 1) {
				return i;
			}
		}
		return -1;
	}
}
