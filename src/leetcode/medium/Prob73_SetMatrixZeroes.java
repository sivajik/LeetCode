package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prob73_SetMatrixZeroes {

	public static void main(String[] args) {
		int[][] m = new int[][] { 
			{ 1, 2, 3, 4 }, 
			{ 5, 0, 7, 8 }, 
			{ 0, 10, 11, 12 }, 
			{ 13, 14, 15, 0 } };

		setZeroes(m);
		for (int i = 0; i < m.length; i++) {
			System.out.println(Arrays.toString(m[i]));
		}

	}

	static public void setZeroes(int[][] matrix) {
		Set<Integer> rowSet = new HashSet<>();
		Set<Integer> colSet = new HashSet<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rowSet.add(i);
					colSet.add(j);
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (rowSet.contains(i) || colSet.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
