package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class P1730_ShortestPathtoGetFood {

	public static void main(String[] args) {

		System.out
				.println(3 == getFood(new char[][] { { 'X', 'X', 'X', 'X', 'X', 'X' }, { 'X', '*', 'O', 'O', 'O', 'X' },
						{ 'X', 'O', 'O', '#', 'O', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X' } }));

		System.out.println(-1 == getFood(new char[][] { { 'X', 'X', 'X', 'X', 'X' }, { 'X', '*', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', '#', 'X' }, { 'X', 'X', 'X', 'X', 'X' } }));

		System.out.println(6 == getFood(new char[][] { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', '*', 'O', 'X', 'O', '#', 'O', 'X' }, { 'X', 'O', 'O', 'X', 'O', 'O', 'X', 'X' },
				{ 'X', 'O', 'O', 'O', 'O', '#', 'O', 'X' }, { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } }));

		System.out.println(2 == getFood(new char[][] { { 'O', '*' }, { '#', 'O' } }));
		System.out.println(-1 == getFood(new char[][] { { 'X', '*' }, { '#', 'X' } }));

	}

	static public int getFood(char[][] grid) {
		if (grid == null || grid[0].length == 0) {
			return 0;
		}

		Point start = null;
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int[][] ans = new int[grid.length][grid[0].length];

		boolean startFound = false;
		for (int i = 0; i < grid.length; i++) {
			visited[i] = new boolean[grid[i].length];
			ans[i] = new int[grid[i].length];

			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '*' && startFound == false) {
					start = new Point(i, j, '*');
					visited[i][j] = true;
					startFound = true;
				}
			}
		}

		Queue<Point> q = new LinkedList<>();
		q.add(start);

		int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		while (!q.isEmpty()) {
			Point currPoint = q.poll();

			if (currPoint.c == '#') {
				return ans[currPoint.x][currPoint.y];
			}

			for (int[] eachDir : dirs) {
				int nextX = currPoint.x + eachDir[0];
				int nextY = currPoint.y + eachDir[1];

				if (nextX >= 0 && nextY >= 0 && nextX < grid.length && nextY < grid[0].length
						&& grid[nextX][nextY] != 'X' && visited[nextX][nextY] == false) {
					q.add(new Point(nextX, nextY, grid[nextX][nextY]));
					visited[nextX][nextY] = true;
					ans[nextX][nextY] = ans[currPoint.x][currPoint.y] + 1;
				}
			}
		}

		return -1;
	}

	static class Point {
		int x;
		int y;
		char c;

		Point(int a, int b, char c) {
			this.x = a;
			this.y = b;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", c=" + c + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + c;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			if (c != other.c)
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}

	}
}
