package leetcode.thirtydays.may;

import java.util.Arrays;

public class Day30_KClosestPoints {

	public static void main(String[] args) {

		for (int[] res : kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1)) {
			System.out.println(Arrays.toString(res));
		}
		System.out.println();

		for (int[] res : kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2)) {
			System.out.println(Arrays.toString(res));
		}
	}

	public static int[][] kClosest(int[][] points, int K) {
		java.util.PriorityQueue<int[]> q = new java.util.PriorityQueue<>(new java.util.Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return -dist(o1) + dist(o2);
			}
		});

		for (int[] eachPoint : points) {
			q.add(eachPoint);
			if (q.size() > K) {
				q.remove();
			}
		}
		int[][] res = new int[q.size()][];
		int size = q.size();
		for (int i = 0; i < size; i++) {
			res[i] = q.poll();
		}
		return res;
	}

	public static int dist(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}
}
