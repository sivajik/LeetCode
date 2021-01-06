package leetcode.revision.week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P120_Triangle {

	public static void main(String[] args) {
		List<List<Integer>> t = new ArrayList<>();
		t.add(Arrays.asList(new Integer[] { 2 }));
		t.add(Arrays.asList(new Integer[] { 3, 4 }));
		t.add(Arrays.asList(new Integer[] { 6, 5, 7 }));
		t.add(Arrays.asList(new Integer[] { 4, 1, 8, 3 }));
		System.out.println(minimumTotal(t));

	}

	static public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}

		List<List<Integer>> dp = new ArrayList<>();

		for (int i = 0; i < triangle.size(); i++) {
			dp.add(i, new ArrayList<>());
		}

		int elem = -1;
		for (int i = 0; i < triangle.size(); i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (i == 0 && j == 0) {
					elem = triangle.get(i).get(j);
				} else {
					elem = triangle.get(i).get(j) + Math.min(getVal(dp, i - 1, j), getVal(dp, i - 1, j - 1));
				}
				dp.get(i).add(j, elem);
			}
		}
		int finalSum = Integer.MAX_VALUE;
		for (Integer i : dp.get(triangle.size() - 1)) {
			finalSum = Math.min(finalSum, i);
		}
		return finalSum;
	}

	private static int getVal(List<List<Integer>> dp, int i, int j) {
		if (i >= 0 && j >= 0 && j < dp.get(i).size()) {
			return dp.get(i).get(j);
		}
		return Integer.MAX_VALUE;
	}
}
