package leetcode.revision.week02;

import java.util.Arrays;

public class P48_RotateImage {

	public static void main(String[] args) {
		rotate(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		System.out.println();
		rotate(new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } });
	}

	static public void rotate(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0;j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		print(matrix);
		
		for (int i = 0; i < matrix.length; i++) {
			reverse(matrix[i]);
		}
		print(matrix);
	}

	private static void reverse(int[] is) {
		for (int i = 0; i < is.length / 2; i++) {
			int temp = is[i];
			is[i] = is[is.length - i - 1];
			is[is.length - i - 1] = temp;
		}
	}

	private static void print(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println();
	}
}
