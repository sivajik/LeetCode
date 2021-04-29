package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob1636_SortArraybyIncreasingFrequency {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(frequencySort(new int[] { 1, 1, 2, 2, 2, 3 })));
		System.out.println(Arrays.toString(frequencySort(new int[] { 2, 3, 1, 3, 2 })));
		System.out.println(Arrays.toString(frequencySort(new int[] { -1, 1, -6, 4, 5, -6, 1, 4, 1 })));

	}

	static public int[] frequencySort(int[] nums) {
		Map<Integer, Integer> m = new HashMap<>();
		for (int n : nums) {
			m.put(n, m.getOrDefault(n, 0) + 1);
		}
		List<Pair> list = new ArrayList<>();
		for (Integer key : m.keySet()) {
			list.add(new Pair(key, m.get(key)));
		}

		list.sort(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.freq == o2.freq) {
					return o2.elem - o1.elem;
				} else {
					return o1.freq - o2.freq;
				}
			}
		});

		int[] op = new int[nums.length];
		int c = 0;
		for (int i = 0; i < list.size(); i++) {
			int freq = list.get(i).freq;
			for (int j = 0; j < freq; j++) {
				op[c++] = list.get(i).elem;
			}
		}
		return op;
	}

	static class Pair {
		int elem;
		int freq;

		Pair(int a, int b) {
			this.elem = a;
			this.freq = b;
		}
	}
}
