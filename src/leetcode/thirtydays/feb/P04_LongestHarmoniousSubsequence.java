package leetcode.thirtydays.feb;

import java.util.HashMap;
import java.util.Map;

public class P04_LongestHarmoniousSubsequence {

	public static void main(String[] args) {
		System.out.println(findLHS(new int[] { 1, 3, 2, 2, 5, 2, 3, 7 }));

	}

	static public int findLHS(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		int cnt = 0;
		for (int key : map.keySet()) {
			if (map.containsKey(key + 1)) {
				cnt = Math.max(cnt, map.get(key) + map.get(key + 1));
			}
		}
		return cnt;
	}
}
