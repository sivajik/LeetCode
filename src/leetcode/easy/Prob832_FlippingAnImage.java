package leetcode.easy;

import java.util.Arrays;

public class Prob832_FlippingAnImage {

	public static void main(String[] args) {
		print(flipAndInvertImage(new int[][] { { 1, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 } }));
		print(flipAndInvertImage(new int[][] {}));
		print(flipAndInvertImage(new int[][] { { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 }, { 1, 0, 0, 1 } }));

	}

	public static int[][] flipAndInvertImage(int[][] a) {
		int rows = a.length;
		int cols = rows;

		for (int i = 0; i < a.length; i++) {
			int ci = 0;
			for (; ci < cols / 2; ci++) {
				int temp = a[i][ci];
				a[i][ci] = a[i][cols - ci - 1];
				a[i][cols - ci - 1] = temp;

				a[i][ci] = (1 + a[i][ci]) % 2;
				a[i][cols - ci - 1] = (1 + a[i][cols - ci - 1]) % 2;
			}

			if (ci == cols / 2 && cols % 2 == 1) {
				a[i][ci] = (1 + a[i][ci]) % 2;
			}
		}
		return a;
	}

	public static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
		System.out.println("===");
	}
}
