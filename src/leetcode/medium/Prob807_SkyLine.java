package leetcode.medium;

public class Prob807_SkyLine {

	public static void main(String[] args) {
		System.out.println(maxIncreaseKeepingSkyline(
				new int[][] { { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } }));
	}

	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		int[] leftRight = new int[grid.length];
		int[] topBtm = new int[grid.length];

		for (int i = 0; i < grid.length; i++) {
			int topViewRowMax = Integer.MIN_VALUE;
			int sideViewLeftview = Integer.MIN_VALUE;
			for (int j = 0; j < grid.length; j++) {
				topViewRowMax = Math.max(topViewRowMax, grid[i][j]);
				sideViewLeftview = Math.max(sideViewLeftview, grid[j][i]);
			}
			leftRight[i] = topViewRowMax;
			topBtm[i] = sideViewLeftview;
		}

		int runningTotal = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				runningTotal += Math.abs(grid[i][j] - Math.min(leftRight[i], topBtm[j]));
			}
		}
		return runningTotal;
	}
}
