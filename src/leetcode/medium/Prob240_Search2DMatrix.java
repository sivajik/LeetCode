package leetcode.medium;

public class Prob240_Search2DMatrix {

	public static void main(String[] args) {
		System.out.println(searchMatrix(new int[][] { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } }, 5));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}

		boolean found = false;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] > target) {
				break;
			}
			found = performBinarySearch(matrix[i], target);
			if (found) {
				return found;
			}
		}
		return false;
	}

	private static boolean performBinarySearch(int[] is, int target) {
		int left = 0, right = is.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (is[mid] == target) {
				return true;
			} else if (target < is[mid]) {
				right = mid - 1;
			} else if (target > is[mid]) {
				left = mid + 1;
			}
		}
		return false;
	}
}