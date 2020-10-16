package leetcode.thirtydays.oct;

public class Day16_Search2DMatrix {

	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][] {
			  {1,   3,  5,  7},
			  {10, 11, 16, 20},
			  {23, 30, 34, 50}
		}, 3));
		System.out.println(searchMatrix(new int[][] {
			  {1,   3,  5,  7},
			  {10, 11, 16, 20},
			  {23, 30, 34, 50}
		}, 13));
	}

	static public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		for (int[] row : matrix) {
			if (target >= row[0] && target <= row[row.length - 1]) {
				return java.util.Arrays.binarySearch(row, target) >= 0;
			}
		}
		return false;
	}
}
