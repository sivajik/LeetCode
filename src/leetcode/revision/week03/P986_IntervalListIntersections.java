package leetcode.revision.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P986_IntervalListIntersections {

	public static void main(String[] args) {
		for (int[] a : intervalIntersection(new int[][] { 
			{ 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } },
				new int[][] { 
			{ 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } })) {
			System.out.println(Arrays.toString(a));
		}
	}

	static public int[][] intervalIntersection(int[][] A, int[][] B) {
		List<int[]> r = new ArrayList<>();

		int i = 0, j = 0;
		while (i < A.length && j < B.length) {
			int start = Math.max(A[i][0], B[j][0]);
			int end = Math.min(A[i][1], B[j][1]);

			if (start <= end) {
				r.add(new int[] { start, end });
			}
			if (A[i][1] < B[j][1]) {
				i++;
			} else {
				j++;
			}
		}

		int[][] res = new int[r.size()][2];
		i = 0;
		for (int[] arr : r) {
			res[i++] = arr;
		}

		return res;
	}
}
