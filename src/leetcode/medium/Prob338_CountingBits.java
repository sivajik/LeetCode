package leetcode.medium;

import java.util.Arrays;

public class Prob338_CountingBits {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(countBitsBruteForce(2)));
		System.out.println(Arrays.toString(countBitsBruteForce(5)));

	}

	public static int[] countBitsBruteForce(int num) {
		int[] result = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			String str = Integer.toBinaryString(i);
			result[i] = (int) str.chars().filter(x -> x == '1').count();
		}
		return result;
	}

	public static int[] countBitsDPMethod(int num) {
		int[] result = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			String str = Integer.toBinaryString(i);
			result[i] = (int) str.chars().filter(x -> x == '1').count();
		}
		return result;
	}
}