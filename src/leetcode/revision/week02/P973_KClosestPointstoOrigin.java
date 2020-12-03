package leetcode.revision.week02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P973_KClosestPointstoOrigin {

	public static void main(String[] args) {
		for (int[] res : kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2)) {
			System.out.println(Arrays.toString(res));
		}
	}

	static public int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return -(sqr(o1[0]) + sqr(o1[1])) + (sqr(o2[0]) + sqr(o2[1]));
			}
		});

		for (int[] eachPoint : points) {
			p.add(eachPoint);
			if (p.size() > K) {
				p.poll();
			}
		}
		int[][] res = new int[K][];
		int i = 0;
		while (!p.isEmpty()) {
			res[i++] = p.poll();
		}
		return res;
	}

	public static int sqr(int a) {
		return a * a;
	}
}
