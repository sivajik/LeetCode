package leetcode.medium;

import java.util.Arrays;

public class Prob915_PartitionArrayintoDisjointIntervals {

	public static void main(String[] args) {
		System.out.println(partitionDisjoint(new int[] { 5, 0, 3, 8, 6 }));
	}

	static public int partitionDisjoint(int[] A) {
		int[] maxLeft = new int[A.length];
		maxLeft[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			maxLeft[i] = Math.max(A[i], maxLeft[i - 1]);
		}
		System.out.println(Arrays.toString(maxLeft));

		int[] minRight = new int[A.length];
		minRight[A.length - 1] = A[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			minRight[i] = Math.min(A[i], minRight[i + 1]);
		}
		System.out.println(Arrays.toString(minRight));

		for (int i = 1; i < A.length; i++) {
			if (maxLeft[i - 1] <= minRight[i]) {
				return i;
			}
		}
		return -1;
	}
}
