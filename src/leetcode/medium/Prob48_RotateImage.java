package leetcode.medium;

public class Prob48_RotateImage {

	public static void main(String[] args) {
		int[][] m = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(m);
	}

	static public void rotate(int[][] matrix) {
		print(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		print(matrix);

		for (int[] eachRow : matrix) {
			swap(eachRow);
		}
		print(matrix);
	}

	private static void swap(int[] eachRow) {
		int low = 0;
		int high = eachRow.length - 1;
		while (low < high) {
			int temp = eachRow[low];
			eachRow[low] = eachRow[high];
			eachRow[high] = temp;
			low++;
			high--;
		}
	}

	static public void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("---");
	}
}
