package leetcode.medium;

public class Prob454_FourSum2 {

	public static void main(String[] args) {
		System.out.println(fourSumCount(new int[] {1, 2}, new int[] {-2, -1}, 
				new int[] {-1, 2}, new int[] {0, 2}));

	}

	// any complex than this, I am out.
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int count = 0;
		java.util.Map<Integer, Integer> map = new java.util.HashMap();
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B.length; j++) {
				int sum = A[i] + B[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < D.length; j++) {
				int sum = C[i] + D[j];
				count = count + map.getOrDefault(-1 * sum, 0);
			}
		}

		return count;
	}
}
