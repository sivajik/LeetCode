package leetcode.revision.week01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P1091_ShortestPathInBinaryMatrix {

	public static void main(String[] args) {
		System.out.println(shortestPathBinaryMatrix(new int[][] { { 0, 1 }, { 1, 0 } }));
		System.out.println(shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } }));
		System.out.println(shortestPathBinaryMatrix(new int[][] { { 0 } }));
	}

	static public int shortestPathBinaryMatrix(int[][] grid) {
		if (grid == null || grid[0].length == 0) {
			return -1;
		}

		if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
			return -1;
		}

		int pathLen = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		Queue<Cell> q = new LinkedList<>();
		q.add(new Cell(0, 0, 0));
		visited[0][0] = true;
		boolean found = false;

		int[][] directions = new int[][] { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 },
				{ 1, 1 } };

		Map<Cell, Cell> path = new HashMap<>();
		path.put(new Cell(0, 0, 0), null);

		while (!q.isEmpty()) {
			Cell cell = q.poll();
			int currRow = cell.row;
			int currCol = cell.col;

			if (currRow == grid.length - 1 && currCol == grid[0].length - 1) {
				// we reached last cell.
				found = true;
			}

			for (int[] eachDirection : directions) {
				int newRow = currRow + eachDirection[0];
				int newCol = currCol + eachDirection[1];

				if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length) {
					if (visited[newRow][newCol] == true) {
						continue;
					}
					if (grid[newRow][newCol] == 1) {
						continue;
					}
					visited[newRow][newCol] = true;
					q.add(new Cell(newRow, newCol, 0));
					path.put(new Cell(newRow, newCol, 0), new Cell(currRow, currCol, 0));
				}
			}

		}

		if (found) {
			Cell currCell = new Cell(grid.length - 1, grid[0].length - 1, 0);
			while (path.get(currCell) != null) {
				System.out.println(currCell);
				currCell = path.get(currCell);
				pathLen++;
			}
			return pathLen + 1;
		} else {
			return -1;
		}
	}

	static class Cell {
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + col;
			result = prime * result + row;
			result = prime * result + val;
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
			Cell other = (Cell) obj;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			if (val != other.val)
				return false;
			return true;
		}

		int row;
		int col;
		int val;

		Cell(int i, int j, int k) {
			this.row = i;
			this.col = j;
			this.val = k;
		}

		@Override
		public String toString() {
			return "Cell [row=" + row + ", col=" + col + "]";
		}
	}
}
