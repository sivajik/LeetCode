package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prob498_DiagonalTraverse {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findDiagonalOrder(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } })));

	}

	static public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[] {};
		}
		int m = matrix.length - 1;
		int n = matrix[0].length - 1;
		List<List<Integer>> ll = new ArrayList<>();

		Set<Pair> visited = new HashSet<>();
		for (int i = m; i >= 0; i--) {
			for (int j = n; j >= 0; j--) {
				int row = i;
				int col = j;
				List<Integer> l = new ArrayList<>();
				while (valid(matrix, row, col) && !visited.contains(new Pair(row, col))) {
					l.add(matrix[row][col]);
					visited.add(new Pair(row, col));
					row--;
					col++;
				}
				if (l.size() > 0) {
					ll.add(l);
				}
			}
		}
		System.out.println(ll);
		boolean reverse = false;
		int[] op = new int[(m + 1) * (n + 1)];
		int cntr = 0;
		for (int i = ll.size() - 1; i >= 0; i--) {
			List<Integer> l = ll.get(i);
			if (reverse) {
				l = reverse(l);
			}

			for (int eachElem : l) {
				op[cntr++] = eachElem;
			}
			reverse = !reverse;
		}
		return op;
	}

	private static List<Integer> reverse(List<Integer> l) {
		List<Integer> op = new ArrayList<Integer>();
		for (int i = l.size() - 1; i >= 0; i--) {
			op.add(l.get(i));
		}
		return op;
	}

	private static boolean valid(int[][] matrix, int row, int col) {
		return row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length;
	}

	static class Pair {
		int r;
		int c;

		Pair(int a, int b) {
			this.r = a;
			this.c = b;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + c;
			result = prime * result + r;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (c != other.c)
				return false;
			if (r != other.r)
				return false;
			return true;
		}

	}
}
