package leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;

public class Prob1293_ShortestPathinaGridwithObstaclesElimination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Solution {
		public int shortestPath(int[][] grid, int k) {

			Queue<int[]> q = new LinkedList<>();
			boolean[][][] visited = new boolean[grid.length][grid[0].length][k + 1];
			// we can have max of k obstacle.

			q.add(new int[] { 0, 0, k });
			visited[0][0][k] = true;
			int level = 0;

			int[] xDir = { 0, 0, -1, 1 };
			int[] yDir = { -1, 1, 0, 0 };

			while (!q.isEmpty()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					int[] curr = q.poll();

					if (curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1) {
						return level;
					}

					for (int index = 0; index < 4; index++) {
						int nextX = curr[0] + xDir[index];
						int nextY = curr[1] + yDir[index];

						if (inBound(grid, nextX, nextY)) {
							if (grid[nextX][nextY] == 0) { // in bounds & empty
								if (visited[nextX][nextY][curr[2]] == false) {
									q.add(new int[] { nextX, nextY, curr[2] });
									visited[nextX][nextY][curr[2]] = true;
								}
							} else {
								// in bounds but occupied. Try removing this and see if that helps.
								if (curr[2] >= 1 && visited[nextX][nextY][curr[2] - 1] == false) {
									q.offer(new int[] { nextX, nextY, curr[2] - 1 });
									visited[nextX][nextY][curr[2] - 1] = true;
								}
							}
						}
					}
				}
				level++;
			}

			return -1;

		}

		private boolean inBound(int[][] grid, int x, int y) {
			return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
		}

	}
}
