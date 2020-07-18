package leetcode.thirtydays.july;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Day17_TopKFreqElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] topKFrequent(int[] nums, int k) {

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

		int[] s = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			s[i] = result.get(i);
		}
		return s;

	}
}
