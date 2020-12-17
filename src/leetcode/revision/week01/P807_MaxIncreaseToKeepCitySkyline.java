package leetcode.revision.week01;

public class P807_MaxIncreaseToKeepCitySkyline {

	public static void main(String[] args) {
		System.out.println(maxIncreaseKeepingSkyline(
				new int[][] { { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } }));

	}

	static public int maxIncreaseKeepingSkyline(int[][] grid) {
		int sum = 0;

		int[] topBottomView = new int[grid[0].length];
		int[] leftRightView = new int[grid.length];

		for (int i = 0; i < grid.length; i++) {
			int lr = Integer.MIN_VALUE;
			int tb = Integer.MIN_VALUE;
			for (int j = 0; j < grid[0].length; j++) {
				lr = Math.max(lr, grid[i][j]);
				tb = Math.max(tb, grid[j][i]);
			}
			leftRightView[i] = lr;
			topBottomView[i] = tb;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				sum += Math.abs(Math.min(leftRightView[i], topBottomView[j]) - grid[i][j]);
			}
		}
		return sum;
	}
}
