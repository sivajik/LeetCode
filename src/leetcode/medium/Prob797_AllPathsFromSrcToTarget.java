package leetcode.medium;

public class Prob797_AllPathsFromSrcToTarget {

	public static void main(String[] args) {
		java.util.List<java.util.List<Integer>> finalList = allPathsSourceTarget(
				new int[][] { { 1, 2 }, { 3 }, { 3 }, {} });
		for (java.util.List<Integer> l : finalList) {
			System.out.println(l);
		}
	}

	static public java.util.List<java.util.List<Integer>> allPathsSourceTarget(int[][] graph) {
		int src = 0;
		int dest = graph.length - 1;

		java.util.List<java.util.List<Integer>> finalList = new java.util.ArrayList<>();

		java.util.List<Integer> list = new java.util.ArrayList<>();

		list.add(0);
		dfs(graph, src, dest, list, finalList);
		
		return finalList;
	}

	static private void dfs(int[][] graph, int src, int dest, java.util.List<Integer> list,
			java.util.List<java.util.List<Integer>> finalList) {
		if (src == dest) {
			// System.out.println("Path :" + list);
			finalList.add(new java.util.ArrayList<>(list));
			return;
		}

		for (int eachAdj : graph[src]) {
			list.add(eachAdj);
			dfs(graph, eachAdj, dest, list, finalList);
			list.remove(list.size() - 1);
		}
	}
}
