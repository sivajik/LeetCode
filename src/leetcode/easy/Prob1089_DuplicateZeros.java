package leetcode.easy;

import java.util.Arrays;

public class Prob1089_DuplicateZeros {

	public static void main(String[] args) {
		duplicateZeros(new int[] { 1, 0, 2, 3, 0, 4, 5, 0 });
		duplicateZeros(new int[] { 1, 2, 3 });
		duplicateZeros(new int[] { 0, 0, 0, 0, 0, 0, 0 });
	}

	public static void duplicateZeros(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				for (int j = arr.length - 1; j > i; j--) {
					arr[j] = arr[j - 1];
				}
				i = i + 1;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
