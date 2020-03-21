package leetcode.easy;

public class Prob0463_IstlandFinder {

	public static void main(String[] args) {
		System.out.println(islandPerimeter(new int[][] {
			{0, 1, 0, 0},
			{1, 1, 1, 0},
			{0, 1, 0, 0},
			{1, 1, 0, 0}	
		}));
		
		System.out.println(islandPerimeter(new int[][] {
			{1, 1},
			{1, 1}	
		}));

	}

	public static int islandPerimeter(int[][] grid) {
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
