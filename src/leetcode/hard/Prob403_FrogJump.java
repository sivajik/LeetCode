package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob403_FrogJump {

	public static void main(String[] args) {
		System.out.println(canCross(new int[] { 0, 1, 3, 5, 6, 8, 12, 17 }));
	}

	static public boolean canCross(int[] stones) {

		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < stones.length; i++) {
			map.put(stones[i], new HashSet<>());
		}

		map.get(0).add(0);// always zeros stone is on 0
		for (int i = 0; i < stones.length; i++) {
			for (int k : map.get(stones[i])) {
				for (int step = k - 1; step <= k + 1; step++) {
					if (step > 0 && map.containsKey(step + stones[i])) {
						map.get(step + stones[i]).add(step);
					}
				}
			}
		}
		System.out.println(map);
		return map.get(stones[stones.length - 1]).size() > 0;

	}
}
