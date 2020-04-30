package leetcode.thirtydays.april;

public class Day17_NumberOfIslands {
	/*
	 * I did not devise this, thank to Nick White
	 */
	public static void main(String[] args) {
		System.out.println(numIslands(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));

		System.out.println(numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));
	}

	public static int numIslands(char[][] grid) {
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count++;
					callBFS(i, j, grid);
				}
			}
		}

		return count;
	}

	public static void callBFS(int i, int j, char[][] grid) {
		// use >= as recursive call comes with +1
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
			return;
		}

		grid[i][j] = '0';
		callBFS(i + 1, j, grid);
		callBFS(i - 1, j, grid);
		callBFS(i, j + 1, grid);
		callBFS(i, j - 1, grid);

	}
}
