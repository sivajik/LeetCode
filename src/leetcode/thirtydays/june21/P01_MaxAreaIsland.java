package leetcode.thirtydays.june21;

public class P01_MaxAreaIsland {
	public static void main(String[] args) {
		System.out.println(maxAreaOfIsland(
				new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
						{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
						{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } }));
	}

	static public int maxAreaOfIsland(int[][] grid) {

		if (grid == null || grid[0].length == 0) {
			return 0;
		}
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				max = Math.max(max, dfs(grid, i, j, visited));
			}
		}
		return max;

	}

	static private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0 || visited[i][j] == true) {
			return 0;
		}
		visited[i][j] = true;
		return 1 + dfs(grid, i - 1, j, visited) + dfs(grid, i + 1, j, visited) + dfs(grid, i, j - 1, visited)
				+ dfs(grid, i, j + 1, visited);
	}
}
