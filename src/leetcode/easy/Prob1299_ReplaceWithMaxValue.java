package leetcode.easy;

import java.util.Arrays;

public class Prob1299_ReplaceWithMaxValue {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(replaceElements(new int[] { 17, 118, 5, 4, 6, 19, 1 })));
		System.out.println(Arrays.toString(replaceElements(new int[] { 17, 18, 5, 4, 6, 1 })));
		System.out.println(Arrays.toString(replaceElements(new int[] { 17, 18 })));
		System.out.println(Arrays.toString(replaceElements(new int[] { 17 })));
	}

	// lovely implementation :) :)
	public static int[] replaceElements(int[] arr) {
		int[] result = new int[arr.length];
		int maxSoFar = Integer.MIN_VALUE;

		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i + 1] > maxSoFar) {
				maxSoFar = arr[i + 1];
			}
			result[i] = maxSoFar;
		}
		result[arr.length - 1] = -1;
		return result;
	}
}
