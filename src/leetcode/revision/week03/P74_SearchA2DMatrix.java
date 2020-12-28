package leetcode.revision.week03;

public class P74_SearchA2DMatrix {

	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 3));
		System.out.println(searchMatrix(new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } }, 13));
	}

	static public boolean searchMatrix(int[][] matrix, int target) {
		int r = matrix.length - 1;
		int c = 0;
		while (r >= 0 && c < matrix[0].length) {
			if (target < matrix[r][c]) {
				r--;
			} else if (target > matrix[r][c]) {
				c++;
			} else {
				return true;
			}
		}
		return false;
	}
}