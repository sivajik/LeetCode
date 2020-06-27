package leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob120_Triangle {

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
		
		int sum = Integer.MAX_VALUE;
		List<List<Integer>> dp = new ArrayList<>();
		
		for (int i = 0; i < triangle.size(); i++) {
			dp.add(i, new ArrayList<>());
		}
		
		int elem;
		for (int i = 0; i < triangle.size(); i++) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				if (i == 0 && j == 0) {
					elem = triangle.get(i).get(j);
				} else {
					elem = triangle.get(i).get(j) + Math.min(getVal(dp,i - 1, j - 1), getVal(dp,i - 1,j));
				}
				dp.get(i).add(j, elem);
			}
		}

		for (Integer i : dp.get(triangle.size() - 1)) {
			sum = Math.min(sum, i);
		}
		return sum;
	}

	static public int getVal(List<List<Integer>> dp, int i, int j) {
		if (i >= 0 && j >= 0 && j < dp.get(i).size()) {
			return dp.get(i).get(j);
		} else {
			return Integer.MAX_VALUE;
		}
	}
}
