package leetcode.thirtydays.feb;

public class P14_IsGraphBipartite {

	public static void main(String[] args) {
		// System.out.println(isBipartite(new int[][] { { 1, 3 }, { 0, 2 }, { 1, 3 }, {
		// 0, 2 } }));
		System.out.println(isBipartite(new int[][] { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } }));
	}

	static public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] colors = new int[n];

		for (int i = 0; i < n; i++) {
			if (colors[i] == 0 && !dfs(i, graph, colors, +1)) {
				return false;
			}
		}
		return true;
	}

	private static boolean dfs(int at, int[][] graph, int[] colors, int color) {
		if (colors[at] != 0) {
			if (colors[at] == color) {
				return true;
			} else
				return false;
		} else {
			colors[at] = color; // without this you can never go out from inf loop
			for (int eachAdj : graph[at]) {
				if (!dfs(eachAdj, graph, colors, -1 * color)) {
					return false;
				}
			}
			return true;
		}
	}
}
