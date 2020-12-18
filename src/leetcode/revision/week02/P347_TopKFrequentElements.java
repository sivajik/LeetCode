package leetcode.revision.week02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P347_TopKFrequentElements {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3 }, 2)));
	}

	static public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int n : nums) {
			m.put(n, 1 + m.getOrDefault(n, 0));
		}
		PriorityQueue<Integer> p = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return m.get(o1) - m.get(o2);
			}
		});

		for (int key : m.keySet()) {
			p.add(key);
			if (p.size() > k) {
				p.poll();
			}
		}

		int[] op = new int[k];
		int c = 0;

		while (!p.isEmpty()) {
			op[c++] = p.poll();
		}

		return op;
	}
}
