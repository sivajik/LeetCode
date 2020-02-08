package leetcode.easy;

import java.util.Arrays;

public class Prob1304_FindNUniques {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sumZero(5)));
		System.out.println(Arrays.toString(sumZero(7)));
		System.out.println(Arrays.toString(sumZero(3)));
		System.out.println(Arrays.toString(sumZero(1)));

		System.out.println(Arrays.toString(sumZero(6)));
		System.out.println(Arrays.toString(sumZero(2)));
	}

	public static int[] sumZero(int n) {
		int[] result = new int[n];

		if (n % 2 == 1) {
			result[n / 2] = 0;
			int count = 1;
			int startIndex = n / 2;
			for (int i = 1; i <= n / 2; i++) {
				result[startIndex + i] = count;
				result[startIndex - i] = -count;
				count++;
			}
		} else {
			// 0 1 2 3 4 5
			int count = n / 2;
			for (int i = 0; i < n / 2; i++) {
				result[i] = -1 * count;
				result[i + (n / 2)] = count;
				count--;
			}
		}

		return result;
	}
}
