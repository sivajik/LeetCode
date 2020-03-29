package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Prob347_TopKFreqElements {

	public static void main(String[] args) {
		System.out.println(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2));
		System.out.println(topKFrequent(new int[] { 1, 2 }, 2));
	}

	// Bruteforce
	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, 1 + map.get(num));
			} else {
				map.put(num, 1);
			}
		}
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>((a, b) -> -map.get(a) + map.get(b));

		map.forEach((key, value) -> {
			pQueue.add(key);
		});

		List<Integer> result = new ArrayList<Integer>();
		while (k > 0) {
			result.add(pQueue.poll());
			k--;
		}
		return result;
	}
}
