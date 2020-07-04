package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Prob1091_ShortestPathInBinaryMatrixForLC {

	public static void main(String[] args) {
		System.out.println(shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 1 } }));
	}

	static public int shortestPathBinaryMatrix(int[][] grid) {
		if (grid[0][0] != 0 || grid[grid.length-1][grid[0].length-1] != 0) {
			return -1;
		}
		
		int moves = 1;

		int[] dR = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] dC = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Map<PairOfCords, PairOfCords> prevMoves = new HashMap<>();

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		visited[0][0] = true;

		prevMoves.put(new PairOfCords(0, 0), new PairOfCords(-1, -1));

		boolean pathFound = false;
		while (!q.isEmpty()) {
			int[] cell = q.poll();

			int r = cell[0];
			int c = cell[1];

			if (r == grid.length - 1 && c == grid[0].length - 1) {
				// reached the last cell in the grid.
				System.out.println("Reached the last cell..");
				pathFound = true;
			}
			for (int i = 0; i < 8; i++) {
				int newR = r + dR[i];
				int newC = c + dC[i];

				if (newR < 0 || newC < 0 || newR == grid.length || newC == grid[0].length) {
					continue;
				}
				if (visited[newR][newC] == true) {
					continue;
				}
				if (grid[newR][newC] == 1) {
					continue;
				}
				// grid[newR][newC] must be zero AND non visited AND good to add.
				visited[newR][newC] = true;
				q.add(new int[] { newR, newC });
				prevMoves.put(new PairOfCords(newR, newC), new PairOfCords(cell[0], cell[1]));
			}
		}

		if (pathFound) {
			PairOfCords temp = prevMoves.get(new PairOfCords(grid.length - 1, grid[0].length - 1));
			while (temp.r != -1 && temp.c != -1) {
				System.out.println(temp);
				moves++;
				temp = prevMoves.get(temp);
			}
			return moves;
		} else {
			return -1;
		}
	}

	static class PairOfCords {
		int r;
		int c;

		PairOfCords(int a, int b) {
			this.r = a;
			this.c = b;
		}

		@Override
		public String toString() {
			return "Cell [r=" + r + ", c=" + c + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + c;
			result = prime * result + r;
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
			PairOfCords other = (PairOfCords) obj;
			if (c != other.c)
				return false;
			if (r != other.r)
				return false;
			return true;
		}
	}
}
