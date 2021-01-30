package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob323_NumberConnectedComponents {

	public static void main(String[] args) {
		System.out.println(countComponents(5, new int[][] { { 0, 1 }, { 1, 2 }, { 3, 4 } }));
		System.out.println(countComponents(5, new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } }));
	}

	static public int countComponents(int n, int[][] edges) {
		List<List<Integer>> g = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			g.add(new ArrayList<>());
		}

		for (int[] eachEdge : edges) {
			g.get(eachEdge[0]).add(eachEdge[1]);
			g.get(eachEdge[1]).add(eachEdge[0]);
		}

		boolean[] visited = new boolean[n];

		Map<Integer, List<Integer>> m = new HashMap<>();
		int color = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i] == false) {
				dfs(i, visited, m, g, color++);
			}
		}

		// System.out.println(m);
		return m.size();
	}

	private static void dfs(int at, boolean[] visited, Map<Integer, List<Integer>> m, List<List<Integer>> g,
			int color) {
		visited[at] = true;

		if (m.get(color) != null) {
			List<Integer> l = m.get(color);
			l.add(at);
			m.put(color, l);
		} else {
			List<Integer> l = new ArrayList<>();
			l.add(at);
			m.put(color, l);
		}
		for (int eachAdjVert : g.get(at)) {
			if (visited[eachAdjVert] == false) {
				dfs(eachAdjVert, visited, m, g, color);
			}
		}
	}
}
