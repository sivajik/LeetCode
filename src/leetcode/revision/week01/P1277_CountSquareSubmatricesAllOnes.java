package leetcode.revision.week01;

public class P1277_CountSquareSubmatricesAllOnes {

	public static void main(String[] args) {
		System.out.println(countSquares(new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } }));
	}

	static public int countSquares(int[][] matrix) {
		int sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (i > 0 && j > 0 && matrix[i][j] == 1) {
					matrix[i][j] = 1 + min(matrix, i, j);
				}
				sum += matrix[i][j];
			}
		}
		return sum;
	}

	private static int min(int[][] m, int i, int j) {
		return Math.min(m[i - 1][j], Math.min(m[i][j - 1], m[i - 1][j - 1]));
	}
}
