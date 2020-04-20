package leetcode.thirtydays;

public class Day18_MinPathSum {

	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } }));

	}

	public static int minPathSum(int[][] grid) {
		// return minPathSumRec(grid, grid.length - 1, grid[0].length - 1);
		return minCost(grid, grid.length - 1, grid[0].length - 1);
	}

	public static int minPathSumRec(int[][] grid, int m, int n) {
		if (m < 0 || n < 0) {
			return Integer.MAX_VALUE;
		} else if (m == 0 && n == 0) {
			return grid[0][0];
		} else {
			return grid[m][n] + Math.min(minPathSumRec(grid, m - 1, n), minPathSumRec(grid, m, n - 1));
		}
	}

	private static int minCost(int cost[][], int m, int n) {
		int i, j;
		int sumsArray[][] = new int[m + 1][n + 1];

		sumsArray[0][0] = cost[0][0];

		for (i = 1; i <= m; i++)
			sumsArray[i][0] = sumsArray[i - 1][0] + cost[i][0];

		for (j = 1; j <= n; j++)
			sumsArray[0][j] = sumsArray[0][j - 1] + cost[0][j];

		for (i = 1; i <= m; i++)
			for (j = 1; j <= n; j++)
				sumsArray[i][j] = Math.min(sumsArray[i - 1][j], sumsArray[i][j - 1]) + cost[i][j];

		return sumsArray[m][n];
	}
}
