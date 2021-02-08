package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob866_PossibleBipartition {

	public static void main(String[] args) {
		System.out.println(possibleBipartition(4, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 4 } }));
		System.out.println(possibleBipartition(3, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } }));
		System.out.println(possibleBipartition(5, new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 1, 5 } }));
	}

	public static boolean possibleBipartition(int N, int[][] dislikes) {
		List<List<Integer>> g = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			g.add(i, new ArrayList<>());
		}

		for (int[] dislike : dislikes) {
			g.get(dislike[0] - 1).add(dislike[1] - 1);
			g.get(dislike[1] - 1).add(dislike[0] - 1);
		}

		int[] colors = new int[N];
		for (int i = 0; i < N; i++) {
			if (colors[i] == 0 && !dfs(i, g, colors, +1)) {
				return false;
			}
		}
		return true;
	}

	private static boolean dfs(int at, List<List<Integer>> graph, int[] colors, int color) {
		if (colors[at] != 0) {
			if (colors[at] == color) {
				return true;
			} else
				return false;
		} else {
			colors[at] = color; // without this you can never go out from inf loop
			for (int eachAdj : graph.get(at)) {
				if (!dfs(eachAdj, graph, colors, -1 * color)) {
					return false;
				}
			}
			return true;
		}
	}
}
