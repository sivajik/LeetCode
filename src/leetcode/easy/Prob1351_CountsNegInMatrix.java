package leetcode.easy;

public class Prob1351_CountsNegInMatrix {

	public static void main(String[] args) {
		System.out.println(countNegatives(new int[][] {
			{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}
		}));

		System.out.println(countNegatives(new int[][] {
			{3,2},{1,0}
		}));
		
		System.out.println(countNegatives(new int[][] {
			{1,-1},{-1,-1}
		}));
		
		System.out.println(countNegatives(new int[][] {
			{-1}
		}));
	}

	public static int countNegatives(int[][] grid) {
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = grid[i].length - 1; j >= 0; j--) {
				if (grid[i][j] < 0) {
					count++;
				} else {
					break;
				}
			}
		}
		return count;
	}
}
