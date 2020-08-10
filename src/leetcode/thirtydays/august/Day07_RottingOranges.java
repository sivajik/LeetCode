package leetcode.thirtydays.august;

public class Day07_RottingOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int orangesRotting(int[][] grid) {

		int startRow, startCol;
		java.util.Queue<Orange> q = new java.util.LinkedList<>();

		for (startRow = 0; startRow < grid.length; startRow++) {
			for (startCol = 0; startCol < grid[startRow].length; startCol++) {
				if (grid[startRow][startCol] == 2) {
					q.add(new Orange(startRow, startCol, 2));
				}
			}
		}

		int elapsedTime = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int x = 0; x < size; x++) {
				Orange temp = q.poll();
				if (temp != null) {
					int i = temp.i;
					int j = temp.j;

					// left
					if (isValid(i, j - 1, grid)) {
						q.add(new Orange(i, j - 1, 2));
						grid[i][j - 1] = 2;
					}
					// right
					if (isValid(i, j + 1, grid)) {
						q.add(new Orange(i, j + 1, 2));
						grid[i][j + 1] = 2;
					}
					// top
					if (isValid(i - 1, j, grid)) {
						q.add(new Orange(i - 1, j, 2));
						grid[i - 1][j] = 2;
					}
					// bottom
					if (isValid(i + 1, j, grid)) {
						q.add(new Orange(i + 1, j, 2));
						grid[i + 1][j] = 2;
					}
				}
			}
			elapsedTime++;
		}

		if (stillFreshOrangesLeft(grid)) {
			return -1;
		}
		return elapsedTime == 0 ? 0 : elapsedTime - 1;

	}

	private boolean stillFreshOrangesLeft(int[][] grid) {
		for (int startRow = 0; startRow < grid.length; startRow++) {
			for (int startCol = 0; startCol < grid[startRow].length; startCol++) {
				if (grid[startRow][startCol] == 1) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isValid(int i, int j, int[][] grid) {
		if (i < 0 || i > grid.length || j < 0 || j > grid[0].length) {
			return false;
		}

		if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length) {
			if (grid[i][j] == 1)
				return true;
			return false;
		}
		return false;
	}
}

class Orange {
	int i;
	int j;
	int status; // 0 or 1 or 2;

	public Orange(int i, int j, int status) {
		super();
		this.i = i;
		this.j = j;
		this.status = status;
	}

}
