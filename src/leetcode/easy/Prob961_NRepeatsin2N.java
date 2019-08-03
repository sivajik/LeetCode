package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Prob961_NRepeatsin2N {

	public static void main(String[] args) {
		System.out.println(repeatedNTimes(new int[] { 1, 2, 3, 3 }));
		System.out.println(repeatedNTimes(new int[] { 2, 1, 2, 5, 3, 2 }));
		System.out.println(repeatedNTimes(new int[] { 5, 1, 5, 2, 5, 3, 5, 4 }));
	}

	public static int repeatedNTimes(int[] A) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int elem : A) {
			if (map.containsKey(elem)) {
				map.put(elem, map.get(elem) + 1);

				if (map.get(elem) == A.length / 2) {
					return elem;
				}
			} else {
				map.put(elem, 1);
			}
		}
		return -1;
	}
}
