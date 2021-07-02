package leetcode.thirtydays.july21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Day02_FindKClosestElements {

	public static void main(String[] args) {
		System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
		System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1));
	}

	static public List<Integer> findClosestElements(int[] arr, int k, int x) {
		PriorityQueue<Integer> p = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				if (Math.abs(a - x) == Math.abs(b - x)) {
					return a - b;
				} else {
					return Math.abs(a - x) - Math.abs(b - x);
				}
			}
		});

		for (int i : arr) {
			p.add(i);
		}
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			res.add(p.poll());
		}

		Collections.sort(res);
		return res;
	}
}
