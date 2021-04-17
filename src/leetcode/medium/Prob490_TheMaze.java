package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Prob490_TheMaze {

	public static void main(String[] args) {

		System.out.println(hasPath(new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 },
				{ 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } }, new int[] { 0, 4 }, new int[] { 4, 4 }));

		System.out.println(hasPath(new int[][] { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 },
				{ 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 0 } }, new int[] { 0, 4 }, new int[] { 3, 2 }));

		System.out.println(hasPath(new int[][] { { 0, 0, 0, 0, 0 }, { 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 0, 1 }, { 0, 1, 0, 0, 0 } }, new int[] { 4, 3 }, new int[] { 0, 1 }));

	}

	static public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		boolean[][] visited = new boolean[maze.length][maze[0].length];

		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		visited[start[0]][start[1]] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			if (curr[0] == destination[0] && curr[1] == destination[1]) {
				return true;
			}

			// we have 4 options here.
			int[] x = new int[] { -1, 1, 0, 0 };
			int[] y = new int[] { 0, 0, 1, -1 };
			for (int i = 0; i < 4; i++) {
				int[] nextPos = new int[] { curr[0] + x[i], curr[1] + y[i] };

				/**
				 * REMEMBER WHILE LOOP HERE
				 */
				while (isValid(nextPos, maze, visited)) {
					// let ball rolling as long as you can go.
					nextPos = new int[] { nextPos[0] + x[i], nextPos[1] + y[i] };
				}
				// you are here means either you 'ALREADY' hit a wall and in a
				// cell which is a wall cell (1)
				// now check if it is a good spot to consider?
				// for that you need to come back one step.
				if (visited[nextPos[0] - x[i]][nextPos[1] - y[i]] == false) {
					visited[nextPos[0] - x[i]][nextPos[1] - y[i]] = true;
					q.add(new int[] { nextPos[0] - x[i], nextPos[1] - y[i] });
				}
			}
		}
		return false;
	}

	private static boolean isValid(int[] nextPos, int[][] maze, boolean[][] visited) {
		int x = nextPos[0];
		int y = nextPos[1];
		if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == 1) {
			return false;
		}
		return true;
	}

}
