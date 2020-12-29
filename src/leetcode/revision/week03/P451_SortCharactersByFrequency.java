package leetcode.revision.week03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P451_SortCharactersByFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String frequencySort(String s) {

		PriorityQueue<Pair> p = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return -o1.frequency + o2.frequency;
			}
		});

		Map<Character, Pair> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, new Pair(c, 1 + map.get(c).frequency));
			} else {
				map.put(c, new Pair(c, 1));
			}
		}

		p.addAll(map.values());

		StringBuilder sbldr = new StringBuilder();
		while (!p.isEmpty()) {
			Pair pp = p.poll();
			for (int i = 0; i < pp.frequency; i++) {
				sbldr.append(pp.c);
			}
		}
		return sbldr.toString();

	}

	class Pair {
		Character c;
		int frequency;

		Pair(Character c, int f) {
			this.c = c;
			this.frequency = f;
		}
	}
}
