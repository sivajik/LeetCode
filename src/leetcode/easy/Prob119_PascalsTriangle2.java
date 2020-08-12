package leetcode.easy;

import java.util.*;

public class Prob119_PascalsTriangle2 {

	public static void main(String[] args) {
		for (int i : getRow(33)) {
			System.out.print(i + " ");
		}

	}

	static public List<Integer> getRow(int rowIndex) {
		map = new HashMap<>();
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i <= rowIndex; i++) {
			result.add(getRowList(i));
		}
		return result.get(rowIndex);
	}

	static Map<Pair, Integer> map = null;

	private static List<Integer> getRowList(int rowIndex) {
		if (rowIndex == 0) {
			map.put(new Pair(0, 0), 1);
			return Arrays.asList(new Integer[] { 1 });
		} else if (rowIndex == 1) {
			map.put(new Pair(1, 0), 1);
			map.put(new Pair(1, 1), 1);
			return Arrays.asList(new Integer[] { 1, 1 });
		} else {
			List<Integer> tempList = new ArrayList<>();
			for (int col = 0; col <= rowIndex; col++) {
				if (col == 0) {
					tempList.add(1);
					map.put(new Pair(rowIndex, 0), 1); // 30
				} else if (col == rowIndex) {
					tempList.add(1);
					map.put(new Pair(rowIndex, col), 1); // 33
				} else {
					// 31, 32
					int val = map.get(new Pair(rowIndex - 1, col)) + map.get(new Pair(rowIndex - 1, col - 1));
					tempList.add(val);
					map.put(new Pair(rowIndex, col), val);
				}
			}
			return tempList;
		}
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
			if (c != other.c)
				return false;
			if (r != other.r)
				return false;
			return true;
		}
	}
}
