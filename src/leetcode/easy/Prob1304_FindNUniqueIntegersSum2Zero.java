package leetcode.easy;

import java.util.Arrays;

public class Prob1304_FindNUniqueIntegersSum2Zero {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(Arrays.toString(sumZero(i)));
		}

	}

	static public int[] sumZero(int n) {
		if (n == 1) {
			return new int[] { 0 };
		}

		int[] op = new int[n];
		int c = 0;
		for (int i = 1; i <= n / 2; i++) {
			op[c++] = i;
			op[c++] = -i;
		}
		if (n % 2 == 1) {
			op[c++] = 0;
		}
		return op;
	}
}
