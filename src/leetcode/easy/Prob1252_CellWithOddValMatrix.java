package leetcode.easy;

public class Prob1252_CellWithOddValMatrix {

	public static void main(String[] args) {
		System.out.println(oddCellsBruteForce(2, 3, new int[][] { { 0, 1 }, { 1, 1 } }));
		System.out.println(oddCellsBruteForce(2, 2, new int[][] { { 1, 1 }, { 0, 0 } }));

	}

	public int oddCells(int n, int m, int[][] indices) {

		return -1;
	}

	public static int oddCellsBruteForce(int n, int m, int[][] indices) {
		System.out.println("------- START ---------");
		int[][] mat = new int[n][m];
		for (int i = 0; i < indices.length; i++) {
			int[] pair = indices[i];
			int row = pair[0];
			int col = pair[1];
			incrementRow(mat, row, m);
			incrementCol(mat, col, n);
			//print(n, m, mat);
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] % 2 != 0) {
					result++;
				}
			}
		}
		return result;
	}

	private static void print(int n, int m, int[][] mat) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(mat[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("=====");
	}

	private static void incrementCol(int[][] mat, int col, int totalRows) {
		for (int i = 0; i < totalRows; i++) {
			mat[i][col] += 1;
		}
	}

	private static void incrementRow(int[][] mat, int row, int totalCol) {
		for (int i = 0; i < totalCol; i++) {
			mat[row][i] += 1;
		}
	}
}
