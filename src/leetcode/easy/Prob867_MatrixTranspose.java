package leetcode.easy;

public class Prob867_MatrixTranspose {

	public static void main(String[] args) {
		print(transpose(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));

	}

	public static int[][] transpose(int[][] A) {
		int[][] B = new int[A[0].length][A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				B[j][i] = A[i][j];
			}
		}

		return B;
	}

	public static void print(int[][] mat) {
		if (mat != null) {
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[i].length; j++) {
					System.out.print(mat[i][j] + "  ");
				}
				System.out.println();
			}
		}
	}
}
