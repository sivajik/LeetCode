package leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prob542_01Matrix {

	public static void main(String[] args) {
		for (int[] r : updateMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } })) {
			System.out.println(Arrays.toString(r));
		}

	}

	static public int[][] updateMatrix(int[][] matrix) {
		int rows = matrix.length;
		if (rows == 0) {
			return matrix;
		}
		int cols = matrix[0].length;
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 0) {
					q.add(new int[] { i, j });
				} else {
					matrix[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		int[][] dir = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];

			for (int i = 0; i < 4; i++) {
				int newX = x + dir[i][0];
				int newY = y + dir[i][1];

				if (newX < 0 || newY < 0 || newX >= rows || newY >= cols || matrix[newX][newY] <= matrix[x][y] + 1)
					continue;
				q.add(new int[] { newX, newY });
				matrix[newX][newY] = matrix[x][y] + 1;
			}
		}
		return matrix;

	}

}
