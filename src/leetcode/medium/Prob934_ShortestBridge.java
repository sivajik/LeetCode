package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Prob934_ShortestBridge {

	public static void main(String[] args) {
		System.out.println(shortestBridge(new int[][] { { 0, 1 }, { 1, 0 } }));

	}

	static public int shortestBridge(int[][] A) {
		int rows = A.length;
		int cols = A[0].length;

		Queue<int[]> q = new LinkedList<>();

		// occupt as much as island area.
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (A[i][j] == 1 && q.isEmpty()) {
					dfs(i, j, q, A);
				}
			}
		}

		// now try to connect this island with next one by moving U D L R
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			for (int[] eachDir : dirs) {
				int i = curr[0] + eachDir[0];
				int j = curr[1] + eachDir[1];

				if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] == -1) {
					// checking -1 as -1 means our own iland area, not a new island
					continue;
				}

				if (A[i][j] == 1) {
					return curr[2]; // 2nd index is distance
				}
				A[i][j] = -1; // mark as visited
				q.add(new int[] { i, j, curr[2] + 1 });
			}
		}
		return -1;
	}

	private static void dfs(int i, int j, Queue<int[]> q, int[][] a) {
		if (i < 0 || i >= a.length || j < 0 || j >= a[0].length || a[i][j] != 1) {
			return;
		}
		a[i][j] = -1; // here a[i][j] is 1 so make it as -1
		q.add(new int[] { i, j, 0 }); // 0 is distance
		dfs(i + 1, j, q, a);
		dfs(i - 1, j, q, a);
		dfs(i, j + 1, q, a);
		dfs(i, j - 1, q, a);
	}
}
