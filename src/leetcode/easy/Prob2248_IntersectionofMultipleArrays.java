package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Prob2248_IntersectionofMultipleArrays {

	public static void main(String[] args) {
		System.out.println(intersection(new int[][] { { 3, 1, 2, 4, 5 }, { 1, 2, 3, 4 }, { 3, 4, 5, 6 } }));
	}

	static public List<Integer> intersection(int[][] nums) {
		int[] res = new int[1001];

		for (int[] num : nums) {
			for (int i = 0; i < num.length; i++) {
				res[num[i]]++;
			}
		}

		List<Integer> op = new ArrayList<>();
		for (int i = 0; i < res.length; i++) {
			if (res[i] == nums.length) {
				op.add(i);
			}
		}

		return op;
	}
}
