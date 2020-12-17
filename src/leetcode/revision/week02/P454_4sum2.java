package leetcode.revision.week02;

import java.util.HashMap;
import java.util.Map;

public class P454_4sum2 {

	public static void main(String[] args) {
		System.out.println(
				fourSumCount(new int[] { 1, 2 }, new int[] { -2, -1 }, new int[] { -1, 2 }, new int[] { 0, 2 }));

	}

	static public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> m = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i] + B[j];
				if (m.containsKey(sum)) {
					m.put(sum, 1 + m.get(sum));
				} else {
					m.put(sum, 1);
				}
			}
		}
		int count = 0;
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i] + D[j];
				if (m.containsKey(-1 * sum)) {
					count = count + m.get(-sum);
				}
			}
		}
		return count;
	}
}
