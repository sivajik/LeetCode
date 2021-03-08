package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prob373_FindKPairsWithSmallestSums {

	public static void main(String[] args) {
		for (List<Integer> l : kSmallestPairs(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3)) {
			System.out.println(l);
		}
		System.out.println();
		for (List<Integer> l : kSmallestPairs(new int[] { 1, 1, 2 }, new int[] { 1, 2, 3 }, 2)) {
			System.out.println(l);
		}
		System.out.println();
		for (List<Integer> l : kSmallestPairs(new int[] { 1, 2 }, new int[] { 3 }, 3)) {
			System.out.println(l);
		}
	}

	static public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return -(o1[0] + o1[1]) + (o2[0] + o2[1]);
			}
		});

		for (int n1 : nums1) {
			for (int n2 : nums2) {
				int[] temp = new int[] { n1, n2 };
				pq.add(temp);
				if (pq.size() > k) {
					pq.poll();
				}
			}
		}
		List<List<Integer>> l = new ArrayList<>();
		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			l.add(0, Arrays.asList(new Integer[] { temp[0], temp[1] }));
		}
		return l;
	}
}
