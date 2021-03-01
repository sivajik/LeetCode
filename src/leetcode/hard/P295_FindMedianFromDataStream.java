package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P295_FindMedianFromDataStream {

	public static void main(String[] args) {
		MedianFinder m = new MedianFinder();
		for (int i : new int[] { 41, 35, 62, 5, 97, 108 }) {
			m.addNum(i);
		}
		System.out.println(m.findMedian());

		m = new MedianFinder();
		for (int i : new int[] { 1, 2, 3 }) {
			m.addNum(i);
		}
		System.out.println(m.findMedian());

		m = new MedianFinder();
		for (int i : new int[] { 1, 2, 3, 4 }) {
			m.addNum(i);
		}
		System.out.println(m.findMedian());

	}

	static class MedianFinder {
		PriorityQueue<Integer> lo = null;
		PriorityQueue<Integer> hi = null;

		public MedianFinder() {
			lo = new PriorityQueue<>();
			hi = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					// TODO Auto-generated method stub
					return -o1 + o2;
				}

			});
		}

		public void addNum(int num) {
			lo.add(num);
			hi.add(lo.poll());

			if (lo.size() < hi.size()) {
				lo.add(hi.poll());
			}
		}

		public double findMedian() {
			if (lo.size() > hi.size()) {
				return lo.peek();
			} else {
				return (lo.peek() + hi.peek()) / 2.0;
			}
		}
	}
}
