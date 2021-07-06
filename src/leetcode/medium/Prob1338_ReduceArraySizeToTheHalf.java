package leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Prob1338_ReduceArraySizeToTheHalf {

	public static void main(String[] args) {
		System.out.println(minSetSize(new int[] { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 }));
		System.out.println(minSetSize(new int[] { 7, 7, 7, 7, 7, 7 }));
		System.out.println(minSetSize(new int[] { 1, 9 }));
		System.out.println(minSetSize(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }));
	}

	static public int minSetSize(int[] arr) {
		Map<Integer, Pair> map = new HashMap<>();

		for (int num : arr) {
			if (map.containsKey(num)) {
				Pair pair = map.get(num);
				pair.setFreq(1 + pair.freq);
				map.put(num, pair);
			} else {
				map.put(num, new Pair(num, 1));
			}
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return -p1.freq + p2.freq;
			}
		});

		for (Pair p : map.values()) {
			pq.add(p);
		}

		int reqSize = arr.length / 2;
		int currSize = 0;
		List<Pair> list = new ArrayList<>();
		while (currSize < reqSize) {
			Pair p = pq.poll();
			list.add(p);
			currSize += p.freq;
		}
		// System.out.println(list);
		return list.size();
	}

	static class Pair {
		int number;
		int freq;

		Pair(int a, int b) {
			this.number = a;
			this.freq = b;
		}

		public void setFreq(int freq) {
			this.freq = freq;
		}

		public String toString() {
			return number + ", ";
		}
	}
}

/*
 * 
 * [3,3,3,3,5,5,5,2,2,7]
 * 
 * 
 * 3 -> 4 times 5 -> 3 times 2 -> 2 times 7 -> 1 times
 * 
 * number, freq
 * 
 * 
 */