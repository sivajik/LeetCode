package leetcode.medium;

import java.util.Arrays;

public class Prob684_RedundantConnection {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findRedundantConnection(new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } })));
		System.out.println();
		System.out.println(Arrays
				.toString(findRedundantConnection(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } })));
		System.out.println();
	}

	static public int[] findRedundantConnection(int[][] edges) {
		int[] parents = new int[edges.length];
		for (int i = 0; i < parents.length; i++) {
			parents[i] = i;
		}

		int[] finalEdge = null;
		for (int[] eachEdge : edges) {
			int u = find(parents, eachEdge[0] - 1);
			int v = find(parents, eachEdge[1] - 1);

			if (u == v) {
				finalEdge = eachEdge;
			} else {
				union(parents, u, v);
			}
		}

		return finalEdge;
	}

	static int find(int[] parents, int i) {
		if (parents[i] == i) {
			return i;
		} else {
			int temp = find(parents, parents[i]);
			parents[i] = temp;
			return parents[i];
		}
	}

	static void union(int[] parents, int i, int j) {
		parents[i] = j;
	}
}
