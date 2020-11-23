package leetcode.revision.week02;

import java.util.*;

public class P692_TopKFrequentWords {

	public static void main(String[] args) {
		System.out.println(topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));
		System.out.println(topKFrequent(
				new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4));
	}

	static public List<String> topKFrequent(String[] words, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {

			@Override
			public int compare(Pair p1, Pair p2) {
				if (p1.freq == p2.freq) {
					return p1.str.compareTo(p2.str);
				} else {
					return -p1.freq + p2.freq;
				}
			}
		});

		Map<String, Pair> m = new HashMap<>();
		for (String word : words) {
			if (m.containsKey(word)) {
				Pair p = m.get(word);
				p.freq = p.freq + 1;
				m.put(word, p);
			} else {
				m.put(word, new Pair(word, 1));
			}
		}

		for (Pair p : m.values()) {
			pq.add(p);
		}

		List<String> op = new ArrayList<>();
		int c = k;
		while (c > 0) {
			op.add(pq.poll().str);
			c--;
		}
		return op;
	}

	static class Pair {
		String str;
		int freq;

		Pair(String a, int f) {
			this.str = a;
			this.freq = f;
		}
	}
}
