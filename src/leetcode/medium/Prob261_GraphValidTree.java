package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob261_GraphValidTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public boolean validTree(int n, int[][] edges) {
		if (n == 1)
			return true;
		if (edges == null || edges.length == 0)
			return false;

		List<List<Integer>> adjList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adjList.add(i, new ArrayList<>());
		}

		for (int[] eachEdge : edges) {
			int u = eachEdge[0];
			int v = eachEdge[1];
			adjList.get(u).add(v);
			adjList.get(v).add(u);
		}

		// check there is a cycle fist
		boolean[] visited = new boolean[n];
		dfs(adjList, 0, visited);

		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false) {
				return false;// disconnected component
			}
		}
		return visited.length == n && edges.length == n - 1;
	}

	private static void dfs(List<List<Integer>> adjList, int at, boolean[] visited) {
		if (visited[at]) {
			return;
		}
		visited[at] = true;

		for (int adjVert : adjList.get(at)) {
			if (visited[adjVert] == false) {
				dfs(adjList, adjVert, visited);
			}
		}
	}
}
