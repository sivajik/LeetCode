package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob417_PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		Solution s = new Solution();
		for (List<Integer> l : s.pacificAtlantic(new int[][] { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 },
				{ 6, 7, 1, 4, 5 }, { 5, 1, 1, 2, 4 } })) {
			System.out.println(l);
		}

	}

	static class Solution {
		int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		int numRows;
		int numCols;
		private int[][] landHeights;

		public List<List<Integer>> pacificAtlantic(int[][] matrix) {
			if (matrix == null || matrix[0].length == 0) {
				return new ArrayList<>();
			}
			this.numRows = matrix.length;
			this.numCols = matrix[0].length;
			this.landHeights = matrix;

			Queue<int[]> pacQ = new LinkedList<>();
			Queue<int[]> atlQ = new LinkedList<>();

			for (int i = 0; i < numRows; i++) {
				pacQ.add(new int[] { i, 0 }); // first col
				atlQ.add(new int[] { i, numCols - 1 }); // last col
			}
			for (int i = 0; i < numCols; i++) {
				pacQ.add(new int[] { 0, i }); // first row
				atlQ.add(new int[] { numRows - 1, i }); // last row
			}

			boolean[][] pacReach = bfs(pacQ);
			boolean[][] atlReach = bfs(atlQ);

			List<List<Integer>> commonCells = new ArrayList<>();
			for (int i = 0; i < numRows; i++) {
				for (int j = 0; j < numCols; j++) {
					if (pacReach[i][j] && atlReach[i][j]) {
						commonCells.add(Arrays.asList(new Integer[] { i, j }));
					}
				}
			}
			return commonCells;
		}

		private boolean[][] bfs(Queue<int[]> que) {
			boolean[][] reachable = new boolean[numRows][numCols];
			while (!que.isEmpty()) {
				int[] cell = que.poll();
				reachable[cell[0]][cell[1]] = true;

				for (int[] eachdir : dir) {
					int newRow = cell[0] + eachdir[0];
					int newCol = cell[1] + eachdir[1];

					if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
						continue;
					}
					if (reachable[newRow][newCol]) {
						continue;
					}

					if (landHeights[newRow][newCol] < landHeights[cell[0]][cell[1]]) {
						continue;
					}
					que.offer(new int[] { newRow, newCol });
				}
			}
			return reachable;
		}
	}
}
