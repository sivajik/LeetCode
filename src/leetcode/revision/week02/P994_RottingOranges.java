package leetcode.revision.week02;

import java.util.LinkedList;
import java.util.Queue;

public class P994_RottingOranges {

	public static void main(String[] args) {
		System.out.println(orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
		System.out.println(orangesRotting(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));
		System.out.println(orangesRotting(new int[][] { { 0, 2 } }));
	}

	static public int orangesRotting(int[][] grid) {
		int freshOrangeCount = 0;

		Queue<Omenge> q = new LinkedList<>();

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					freshOrangeCount++;
				} else if (grid[i][j] == 2) {
					q.add(new Omenge(i, j, 2));
				}
			}
		}
		// say there are no fresh oranges, what do you do?
		if (freshOrangeCount == 0) {
			return 0;
		}
		int timer = 0;
		int rottenNowCount = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Omenge o = q.poll();

				int currRow = o.row;
				int currCol = o.col;

				if (isValidOrange(currRow + 1, currCol, grid)) {
					q.add(new Omenge(currRow + 1, currCol, 2));
					grid[currRow + 1][currCol] = 2;
					rottenNowCount++;
				}
				if (isValidOrange(currRow - 1, currCol, grid)) {
					q.add(new Omenge(currRow - 1, currCol, 2));
					grid[currRow - 1][currCol] = 2;
					rottenNowCount++;
				}
				if (isValidOrange(currRow, currCol + 1, grid)) {
					q.add(new Omenge(currRow, currCol + 1, 2));
					grid[currRow][currCol + 1] = 2;
					rottenNowCount++;
				}
				if (isValidOrange(currRow, currCol - 1, grid)) {
					q.add(new Omenge(currRow, currCol - 1, 2));
					grid[currRow][currCol - 1] = 2;
					rottenNowCount++;
				}
			}
			timer++;
		}
		// there 'were' rotten oranges and...
		if (freshOrangeCount > 0 && freshOrangeCount == rottenNowCount) {
			return timer - 1;
		}
		return -1;
	}

	private static boolean isValidOrange(int i, int j, int[][] grid) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 1) {
			return false;
		}

		if (i >= 0 && j >= 0 && i <= grid.length - 1 && j <= grid[i].length - 1 && grid[i][j] == 1) {
			return true;
		}
		return false;
	}

	static class Omenge {
		int row;
		int col;
		int status;

		Omenge(int i, int j, int status) {
			this.row = i;
			this.col = j;
			this.status = status;
		}
	}
}
