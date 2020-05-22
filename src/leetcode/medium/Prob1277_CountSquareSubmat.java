package leetcode.medium;

public class Prob1277_CountSquareSubmat {

	public static void main(String[] args) {
		System.out.println(countSquares(new int[][] {
			  {0,1,1,1},
			  {1,1,1,1},
			  {0,1,1,1}
		}));

		System.out.println(countSquares(new int[][] {
			  {1,0,1},
			  {1,1,0},
			  {1,1,0}
		}));		

	}

	public static int countSquares(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i >0 && j > 0 && matrix[i][j] > 0) {
					matrix[i][j] = 1 + Math.min( matrix[i-1][j-1], Math.min(matrix[i-1][j], matrix[i][j-1]));					
				}
				sum += matrix[i][j];
			}
		}
		
		return sum;
	}
}
