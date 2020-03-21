package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob1329_SortMatrixDiagonally {

	public static void main(String[] args) {
		print(diagonalSort(new int[][] { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } }));
		print(diagonalSort(new int[][] { { 3, 8, 5, 4, 9 }, { 9, 0, 1, 2, 3 }, { 4, 6, 7, 2, 3 }, { 8, 4, 3, 5, 1 } }));
	}

	/*
	 * Brute Force - I hate this. However, it's inline.
	 */
	public static int[][] diagonalSort(int[][] mat) {
		int rowCount = mat.length; // 3
		int colCount = mat[0].length; // 4

		for (int i = 0; i < rowCount; i++) {
			int k = i;
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0;; j++, k++) {
				try {
					list.add(mat[k][j]);
				} catch (Exception e) {
					break;
				}
			}

			Collections.sort(list);
			k = i;
			int listCounter = 0;
			for (int j = 0;; j++, k++) {
				try {
					mat[k][j] = list.get(listCounter++);
				} catch (Exception e) {
					break;
				}
			}
		}

		for (int i = 1; i < colCount; i++) {
			int k = i;
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0;; j++, k++) {
				try {
					list.add(mat[j][k]);
				} catch (Exception e) {
					break;
				}
			}

			Collections.sort(list);
			k = i;
			int listCounter = 0;
			for (int j = 0;; j++, k++) {
				try {
					mat[j][k] = list.get(listCounter++);
				} catch (Exception e) {
					break;
				}
			}
		}
		return mat;

	}

	public static int[][] transpose(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				mat[i][j] = mat[j][i];
			}
		}
		return mat;
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
