package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob1059_AllPathsFromSourceLeadToDestination {

	public static void main(String[] args) {
		/*
		 * System.out.println(false == leadsToDestination(3, new int[][] { { 0, 1 }, {
		 * 0, 2 } }, 0, 2)); System.out .println(false == leadsToDestination(4, new
		 * int[][] { { 0, 1 }, { 0, 3 }, { 1, 2 }, { 2, 1 } }, 0, 2));
		 */System.out
				.println(true == leadsToDestination(4, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 3 } }, 0, 3));
		/*
		 * System.out.println(false == leadsToDestination(3, new int[][] { { 0, 1 }, {
		 * 1, 1 }, { 1, 2 } }, 0, 2)); System.out.println(false == leadsToDestination(2,
		 * new int[][] { { 0, 1 }, { 1, 1 } }, 0, 1));
		 */
	}

	static public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
		List<List<Integer>> adjList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjList.add(i, new ArrayList<>());
		}

		int[] indegreeCounts = new int[n];

		for (int[] eachEdge : edges) {
			int u = eachEdge[0];
			int v = eachEdge[1];
			adjList.get(u).add(v);
			indegreeCounts[v]++;
		}

		boolean[] visited = new boolean[n];
		// visited[source] = true;
		boolean cycle = dfs(adjList, source, destination, visited, indegreeCounts);

		if (cycle) {
			return false;
		} else {
			return indegreeCounts[destination] == 0;
		}
	}

	private static boolean dfs(List<List<Integer>> adjList, int source, int destination, boolean[] visited,
			int[] indegreeCounts) {
		if (visited[source]) {
			return false;
		}

		visited[source] = true;
		for (int eachAdjVert : adjList.get(source)) {
			if (visited[eachAdjVert] == false) {
				if (eachAdjVert == destination) {
					indegreeCounts[destination]--;
					return false;
				} else {
					return dfs(adjList, eachAdjVert, destination, visited, indegreeCounts);
				}
			}
		}
		return false;
	}
}
