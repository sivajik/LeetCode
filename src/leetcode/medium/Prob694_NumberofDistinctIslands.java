package leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Prob694_NumberofDistinctIslands {

	public static void main(String[] args) {
		numDistinctIslands(new int[][] {
			{1,1,0,0,0},
			{1,1,0,0,0},
			{0,0,0,1,1},
			{0,0,0,1,1}
		});
		
		System.out.println();
		numDistinctIslands(new int[][] {
			{1,1,0,1,1},
			{1,0,0,0,0},
			{0,0,0,0,1},
			{1,1,0,1,1}
		});


	}

	private static int R[] = { 0, 0, 1, -1 };
	private static int C[] = { 1, -1, 0, 0 };
	private static int D[] = { 1, 2, 3, 4 };

	static public int numDistinctIslands(int[][] grid) {
		Set<String> distinct = new HashSet<>();
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					distinct.add(layout(i, j, grid));
				}
			}
		}
		System.out.println(distinct);
		return distinct.size();
	}

	private static String layout(int i, int j, int grid[][]) {
		StringBuilder sb = new StringBuilder();
		Queue<int[]> queue = new LinkedList<>();
		int size, current[], nR, nC;

		queue.add(new int[] { i, j });

		while (!queue.isEmpty()) {
			size = queue.size();

			for(int ii = 0; ii < size; ii++) {
				current = queue.poll();

				for (int k = 0; k < R.length; k++) {
					nR = current[0] + R[k];
					nC = current[1] + C[k];

					if (nR < 0 || nR >= grid.length || nC < 0 || nC >= grid[0].length || grid[nR][nC] != 1) {
						sb.append('X');
						continue;
					}

					if (grid[nR][nC] == 1) {
						queue.add(new int[] { nR, nC });
						grid[nR][nC] = 2;
						sb.append(D[k]);
					}
				}
			}
		}

		return sb.toString();
	}
}
