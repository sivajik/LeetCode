package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Prob451_SortCharsByFreq {

	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
		System.out.println(frequencySort("cccaaa"));
		System.out.println(frequencySort(""));
		System.out.println(frequencySort("Aabb"));
	}

	public static String frequencySort(String s) {
		Map<Character, Pair> map = new HashMap<Character, Pair>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, new Pair(c, 1 + map.get(c).freq));
			} else {
				map.put(c, new Pair(c, 1));
			}
		}

		List<Pair> list = new ArrayList<>(map.values());
		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.freq - o1.freq;
			}
		});

		String res = list.stream().map((Pair p) -> p.toString()).collect(Collectors.joining());
		return res;
	}
}

class Pair {
	public Pair(Character c, Integer freq) {
		super();
		this.c = c;
		this.freq = freq;
	}

	Character c;
	Integer freq;

	@Override
	public String toString() {
		StringBuilder bldr = new StringBuilder();
		for (int i = 0; i < freq; i++) {
			bldr.append(c);
		}
		return bldr.toString();
	}
}
