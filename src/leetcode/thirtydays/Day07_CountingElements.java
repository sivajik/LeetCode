package leetcode.thirtydays;

import java.util.HashMap;
import java.util.Map;

public class Day07_CountingElements {

	public static void main(String[] args) {
		System.out.println(countElements(new int[] { 1, 2, 3 }));
		System.out.println(countElements(new int[] { 1, 1, 3, 3, 5, 5, 7, 7 }));
		System.out.println(countElements(new int[] { 1, 3, 2, 3, 5, 0 }));
		System.out.println(countElements(new int[] { 1, 1, 2, 2 }));
	}

	// since max len of arr is 1000, I am ok with space.
	public static int countElements(int[] arr) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : arr) {
			if (!map.containsKey(num)) {
				map.put(num, 1);
			}
		}

		for (int num : arr) {
			if (map.containsKey(num) && map.containsKey(num + 1)) {
				count += 2;
			}
		}
		return count / 2;
	}
}
