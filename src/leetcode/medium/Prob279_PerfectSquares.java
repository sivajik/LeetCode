package leetcode.medium;

public class Prob279_PerfectSquares {

	public static void main(String[] args) {
		System.out.println(numSquares(12));

	}

	static public int numSquares(int n) { // n = 12
		int[] ret = new int[n + 1];
		java.util.Arrays.fill(ret, 100000);

		ret[0] = 0;
		ret[1] = 1;

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j * j <= i; ++j) {
				ret[i] = Math.min(ret[i - j * j] + 1, ret[i]);
			}
		}
		return ret[n];
	}
}
