package leetcode.thirtydays.june;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Day12_FindChepeastFlights {

	public static void main(String[] args) {
		System.out.println(findCheapestPrice(3, new int[][] { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } }, 0, 2, 1));
	}

	static public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		List<List<int[]>> g = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			g.add(new ArrayList<>());
		}

		for (int[] eachTrip : flights) {
			int u = eachTrip[0];
			int v = eachTrip[1];
			int w = eachTrip[2];
			g.get(u).add(new int[] { v, w });
		}

		PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		q.add(new int[] { src, 0, 0 });

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int srcCity = temp[0];
			int distance = temp[1];
			int cost = temp[2];

			if (srcCity == dst) {
				return cost;
			}

			if (distance <= K) {
				for (int[] eachAdjCity : g.get(srcCity)) {
					q.add(new int[] { eachAdjCity[0], distance + 1, cost + eachAdjCity[1] });
				}
			}
		}
		return -1;
	}
}
