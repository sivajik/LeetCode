package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class Prob346_MovingAveragefromDataStream {

	public static void main(String[] args) {
		MovingAverage obj = new MovingAverage(3);
		System.out.println(obj.next(1));
		System.out.println(obj.next(10));
		System.out.println(obj.next(3));
		System.out.println(obj.next(5));
	}

	static class MovingAverage {
		Deque<Integer> q;
		int size;
		int totalElemCount = 0;
		double sum = 0;

		public MovingAverage(int size) {
			q = new ArrayDeque<>();
			this.size = size;
		}

		public double next(int val) {
			totalElemCount++;
			q.add(val);

			int firstelem = 0;
			if (totalElemCount > size) {
				// elem are moer than window size then remove first elem.
				firstelem = q.poll();
			}
			sum = sum + val - firstelem;
			return sum / Math.min(size, totalElemCount);

		}
	}
}
