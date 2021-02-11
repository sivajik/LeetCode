package leetcode.medium;

public class Prob695_MaxAreaOfIsland {

	public static void main(String[] args) {
		System.out.println(maxAreaOfIsland(
				new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
						{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
						{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }));
	}

	static public int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}

		boolean[][] visited = new boolean[grid.length][grid[0].length];

		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				res = Math.max(res, dfs(grid, i, j, visited));
			}
		}

		return res;
	}

	private static int dfs(int[][] grid, int i, int j, boolean[][] visited) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || visited[i][j] == true || grid[i][j] == 0) {
			return 0;
		}

		visited[i][j] = true;
		int a = dfs(grid, i - 1, j, visited);
		int b = dfs(grid, i + 1, j, visited);
		int c = dfs(grid, i, j + 1, visited);
		int d = dfs(grid, i, j - 1, visited);
		return 1 + a + b + c + d;
	}
}
