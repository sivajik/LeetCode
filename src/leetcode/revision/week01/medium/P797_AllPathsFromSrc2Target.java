package leetcode.revision.week01.medium;

import java.util.ArrayList;
import java.util.List;

public class P797_AllPathsFromSrc2Target {

	public static void main(String[] args) {
		java.util.List<java.util.List<Integer>> finalList = allPathsSourceTarget(
				new int[][] { { 1, 2 }, { 3 }, { 3 }, {} });
		for (java.util.List<Integer> l : finalList) {
			System.out.println(l);
		}
		System.out.println();
		
		/*java.util.List<java.util.List<Integer>> finalList1 = allPathsSourceTarget(
				new int[][] { {4,3,1},{3,2,4},{3},{4},{}});
		for (java.util.List<Integer> l : finalList1) {
			System.out.println(l);
		}*/
	}

	static public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		int src = 0;
		int dest = graph.length - 1;
		List<List<Integer>> res = new ArrayList<>();
		boolean[] visited = new boolean[graph.length];
		
		List<Integer> tempList = new ArrayList<>();
		dfs(graph, src, dest, visited, res, tempList);
		return res;
	}

	static private void dfs(int[][] graph, int src, int dest, boolean[] visited, List<List<Integer>> res,
			List<Integer> tempList) {
		if (src == dest) {
			// we reached destination
			tempList.add(dest);
			res.add(new ArrayList<>(tempList));
			return;
		}
		
		visited[src] = true;
		tempList.add(src);
		
		for (int eachAdjVertOfSrc : graph[src]) {
			if (visited[eachAdjVertOfSrc] == false) {
				dfs(graph, eachAdjVertOfSrc, dest, visited, res, tempList);
				visited[eachAdjVertOfSrc] = false;
				tempList.remove(tempList.size()- 1);
			}
		}
	}
}
