package leetcode.revision.week03;

public class P240_SearchA2DMatrix2 {

	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 8));
	}

	// start at bottom left.
	static public boolean searchMatrix(int[][] matrix, int target) {
		int r = matrix.length - 1;
		int c = 0;

		while (r >= 0 && c <= matrix[0].length - 1) {
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
