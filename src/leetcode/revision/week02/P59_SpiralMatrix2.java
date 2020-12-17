package leetcode.revision.week02;

import java.util.Arrays;

public class P59_SpiralMatrix2 {

	public static void main(String[] args) {
		for (int[] a : generateMatrix(3)) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
		
		for (int[] a : generateMatrix(1)) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
		
		for (int[] a : generateMatrix(4)) {
			System.out.println(Arrays.toString(a));
		}
	}

	
	static public int[][] generateMatrix(int n) {
		int[][] op = new int[n][n];
		for (int i = 0; i < n; i++) {
			op[i] = new int[n];
		}
		
		int[] rowDir = { 0, 1, 0, -1 };
		int[] colDir = { 1, 0, -1, 0 };

		int r = 0, c = 0, di = 0;
		
		boolean[][] seen = new boolean[n][n];
		
		for (int i = 0; i < n*n; i++) {
			op[r][c] = i+1;
			seen[r][c] = true;
			int newR = r + rowDir[di];
			int newC = c + colDir[di];
			
			if (newR <0 || newC < 0 || newR >= n || newC >= n || seen[newR][newC] == true) {
				di = (di + 1) % 4;
				r = r + rowDir[di];
				c = c + colDir[di];
			} else {
				r = newR;
				c = newC;
			}
		}
		return op;
	}
}
