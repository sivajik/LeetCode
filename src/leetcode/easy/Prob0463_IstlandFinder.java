package leetcode.easy;

public class Prob0463_IstlandFinder {

	public static void main(String[] args) {
		System.out.println(
				islandPerimeter(new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } }));

		System.out.println(islandPerimeter(new int[][] { { 1, 0 }, { 1, 0 } }));

	}

	static int count = 0;

	public static int islandPerimeter(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
			return 0;
		}
		
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					BFS(grid, i, j, visited);
				}
			}
		}
		return count;
	}

	private static boolean BFS(int[][] grid, int i, int j, boolean[][] visited) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
			return false;
		}
		if (grid[i][j] != 1) {
			return false;
		}

		if(visited[i][j] == true) {
			return true;
		}
		
		visited[i][j] = true;
		int perimeter = 4;

		if (BFS(grid, i + 1, j, visited)) {
			perimeter--;
		}
		if (BFS(grid, i - 1, j, visited)) {
			perimeter--;
		}
		if (BFS(grid, i , j+1, visited)) {
			perimeter--;
		}
		if (BFS(grid, i , j-1, visited)) {
			perimeter--;
		}
		count += perimeter;
		return true;
	}

	public static int islandPerimeter1(int[][] grid) {
		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (1 == grid[i][j]) {
					int edgeCount = 4;
					if (isLeftExists(grid, i, j)) {
						edgeCount--;
					}
					if (isRightExists(grid, i, j)) {
						edgeCount--;
					}
					if (isTopExists(grid, i, j)) {
						edgeCount--;
					}
					if (isBottomExists(grid, i, j)) {
						edgeCount--;
					}
					sum += edgeCount;
				}
			}
		}

		return sum;
	}

	private static boolean isBottomExists(int[][] grid, int i, int j) {
		return i + 1 < grid.length && grid[i + 1][j] == 1;
	}

	private static boolean isTopExists(int[][] grid, int i, int j) {
		return i - 1 >= 0 && grid[i - 1][j] == 1;
	}

	private static boolean isRightExists(int[][] grid, int i, int j) {
		return j + 1 < grid[i].length && grid[i][j + 1] == 1;
	}

	private static boolean isLeftExists(int[][] grid, int i, int j) {
		return j - 1 >= 0 && grid[i][j - 1] == 1;
	}
}
