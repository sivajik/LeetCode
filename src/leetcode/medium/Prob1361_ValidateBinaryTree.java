package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob1361_ValidateBinaryTree {

	public static void main(String[] args) {
		System.out.println(validateBinaryTreeNodes(4, new int[] { 1, -1, 3, -1 }, new int[] { 2, -1, -1, -1 }));
		System.out.println("---- ==== ----");
		System.out.println(validateBinaryTreeNodes(4, new int[] { 1, -1, 3, -1 }, new int[] { 2, 3, -1, -1 }));
		System.out.println("---- ==== ----");
		System.out.println(validateBinaryTreeNodes(2, new int[] { 1, 0 }, new int[] { -1, -1 }));
		System.out.println("---- ==== ----");
		System.out.println(
				validateBinaryTreeNodes(6, new int[] { 1, -1, -1, 4, -1, -1 }, new int[] { 2, -1, -1, 5, -1, -1 }));
		System.out.println("---- ==== ----");
		System.out.println(validateBinaryTreeNodes(5, new int[] { 1, 3, -1, -1, -1 }, new int[] { -1, 2, 4, -1, -1 }));
		System.out.println("---- ==== ----");
		System.out.println(validateBinaryTreeNodes(2, new int[] { -1, 0 }, new int[] { -1, -1 }));
	}

	static public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
		int vertexCount = n;
		List<Integer>[] adj = new ArrayList[vertexCount];

		for (int i = 0; i < vertexCount; i++) {
			adj[i] = new ArrayList<Integer>();
			if (leftChild[i] != -1) {
				adj[i].add(leftChild[i]);
			}
			if (rightChild[i] != -1) {
				adj[i].add(rightChild[i]);
			}
		}

		// cycle exists check?
		boolean[] visited = new boolean[vertexCount];
		cycleExists = false;
		DFSCycleExists(0, visited, adj);
		if (cycleExists) {
			return false;
		}

		// ensure no disconnected trees lies there.
		for (int i = 0; i < vertexCount; i++) {
			if (visited[i] == false) {
				System.out.println("Disconnected components in the forest");
				return false;
			}
		}

		// parents check. any inwards vertex with >0 count means not a tree
		int[] inwardsCount = new int[vertexCount];
		for (int i = 0; i < vertexCount; i++) {
			for (int eachAdjVer : adj[i]) {
				if (inwardsCount[eachAdjVer] > 0) {
					System.out.println(
							"Invalidating vertex : " + eachAdjVer + " with " + inwardsCount[eachAdjVer] + " parents");
					return false;
				} else {
					inwardsCount[eachAdjVer]++;
				}
			}
		}
		return true;
	}

	static boolean cycleExists = false;

	private static void DFSCycleExists(int i, boolean[] visited, List<Integer>[] adj) {
		visited[i] = true;
		for (int eachAdjVert : adj[i]) {
			if (i != eachAdjVert) { // needed???
				if (visited[eachAdjVert] == true) {
					System.out.println("cycle exists: " + i + " -> " + eachAdjVert);
					cycleExists = true;
				} else {
					DFSCycleExists(eachAdjVert, visited, adj);
				}
			}
		}
	}
}
