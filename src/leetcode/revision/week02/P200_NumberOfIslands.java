package leetcode.revision.week02;

public class P200_NumberOfIslands {

	public static void main(String[] args) {
		System.out.println(numIslands(new char[][] { 
			{ '1', '1', '1', '1', '0' }, 
			{ '1', '1', '0', '1', '0' },
			{ '1', '1', '0', '0', '0' }, 
			{ '0', '0', '0', '0', '0' } }));

		System.out.println(numIslands(new char[][] { 
			{ '1', '1', '0', '0', '0' }, 
			{ '1', '1', '0', '0', '0' },
			{ '0', '0', '1', '0', '0' }, 
			{ '0', '0', '0', '1', '1' } }));
	}

	static public int numIslands(char[][] grid) {
		int count = 0;
		if (grid == null || grid.length == 0) {
			return count;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					count += dfs(grid, i, j);
				}
			}
		}
		return count;
	}

	private static int dfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
			return 0;
		}
		grid[i][j] = '0';
		dfs(grid, i + 1, j);
		dfs(grid, i - 1, j);
		dfs(grid, i, j + 1);
		dfs(grid, i, j - 1);
		return 1;
	}
}
