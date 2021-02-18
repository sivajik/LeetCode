package leetcode.medium;

public class Prob413_ArithmeticSlices {

	public static void main(String[] args) {
		System.out.println(numberOfArithmeticSlices(new int[] { 1, 2, 3, 4 }));

	}

	static public int numberOfArithmeticSlices(int[] A) {
		int count = 0;
		int dp = 0;
		for (int i = 2; i < A.length; i++) {
			if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
				dp++;
				count = count + dp;
			} else {
				dp = 0;
			}
		}
		return count;
	}
}
