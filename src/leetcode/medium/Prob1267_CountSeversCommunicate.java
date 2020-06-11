package leetcode.medium;

public class Prob1267_CountSeversCommunicate {

	public static void main(String[] args) {
		System.out.println(countServers(new int[][] {
			{1, 0}, {1, 1}
		}));

	}

	static public int countServers(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					int result = DFS(i, j, grid);
					count += result == 1 ? 0 : result;
				}
			}
		}
		return count;
	}

	static private int DFS(int r, int c, int[][] grid) {
		grid[r][c] = 0;
		int res = 1;

		for (int i = 0; i < grid.length; i++) {
			if (grid[i][c] == 1) {
				res += DFS(i, c, grid);
			}
		}

		for (int i = 0; i < grid[0].length; i++) {
			if (grid[r][i] == 1) {
				res += DFS(r, i, grid);
			}
		}

		return res;
	}
}
