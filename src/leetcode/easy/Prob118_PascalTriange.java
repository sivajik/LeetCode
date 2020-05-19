package leetcode.easy;

import java.util.Arrays;
import java.util.List;

public class Prob118_PascalTriange {

	public static void main(String[] args) {
		System.out.println(generate(5));
	}

	static class Pair {
		int r;
		int c;

		Pair(int r, int c) {
			this.r = r;
			this.c = c;
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
			if (other.r == r && other.c == c) {
				return true;
			}
			if (c != other.c)
				return false;
			if (r != other.r)
				return false;
			return true;
		}

	}

	static java.util.Map<Pair, Integer> map = new java.util.HashMap<>();

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> finalList = new java.util.ArrayList<>();
		for (int i = 1; i <= numRows; i++) {
			List<Integer> l = populatePascals(i);
			finalList.add(l);
		}
		return finalList;
	}

	private static List<Integer> populatePascals(int row) {
		if (row == 1) {
			map.put(new Pair(1, 1), 1);
			Integer[] t = new Integer[] { 1 };
			return Arrays.asList(t);
		} else if (row == 2) {
			map.put(new Pair(2, 1), 1);
			map.put(new Pair(2, 2), 1);
			Integer[] t = new Integer[] { 1, 1 };
			return Arrays.asList(t);
		} else {
			List<Integer> l = new java.util.ArrayList<>();
			for (int col = 1; col <= row; col++) {
				if (col == 1) {
					l.add(1);
					map.put(new Pair(row, 1), 1);
				} else if (col == row) {
					l.add(1);
					map.put(new Pair(row, col), 1);
				} else {
					int left = map.get(new Pair(row - 1, col - 1));
					int right = map.get(new Pair(row - 1, col));
					int temp = left + right;
					map.put(new Pair(row, col), temp);
					l.add(temp);
				}
			}
			return l;
		}
	}
}
