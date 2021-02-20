package leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob1192_CriticalConnectionsinaNetwork {

	public static void main(String[] args) {
		// [0,1],[1,2],[2,0],[1,3]
		List<List<Integer>> connections = new ArrayList<>();
		connections.add(Arrays.asList(new Integer[] { 0, 1 }));
		connections.add(Arrays.asList(new Integer[] { 1, 2 }));
		connections.add(Arrays.asList(new Integer[] { 2, 0 }));
		connections.add(Arrays.asList(new Integer[] { 1, 3 }));
		connections.add(Arrays.asList(new Integer[] { 3, 4 }));
		connections.add(Arrays.asList(new Integer[] { 4, 5 }));
		connections.add(Arrays.asList(new Integer[] { 5, 3 }));

		for (List<Integer> l : criticalConnections(6, connections)) {
			System.out.println(l);
		}

	}

	static boolean[] visited;
	static int[] ids;
	static int[] lows;
	static int counter = 0;
	static List<List<Integer>> adj;

	static List<List<Integer>> bridges;

	public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		bridges = new ArrayList<>();

		if (connections == null || connections.size() == 0) {
			return bridges;
		}

		adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(i, new ArrayList<>());
		}

		for (List<Integer> edge : connections) {
			adj.get(edge.get(0)).add(edge.get(1));
			adj.get(edge.get(1)).add(edge.get(0));
		}

		visited = new boolean[n];
		ids = new int[n];
		lows = new int[n];

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(i, -1);
			}
		}

		return bridges;
	}

	private static void dfs(int at, int parent) {
		visited[at] = true;

		ids[at] = lows[at] = counter++;

		for (Integer eachAdj : adj.get(at)) {
			if (eachAdj == parent) {
				continue;// in undirected graph, u got 2 way edges
			}

			if (visited[eachAdj] == false) {
				dfs(eachAdj, at);
				lows[at] = Math.min(lows[at], lows[eachAdj]);
				if (ids[at] < lows[eachAdj]) {
					// System.out.println(at + " -> " + eachAdj);
					bridges.add(Arrays.asList(new Integer[] { at, eachAdj }));
				}

			} else {
				// already visited vertex
				lows[at] = Math.min(lows[at], ids[eachAdj]);
			}
		}
	}

}
