package leetcode.easy;

import java.util.Arrays;

public class Prob905_SortArrayByParity {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortArrayByParity(new int[] { 3, 1, 2, 4 })));

	}

	public static int[] sortArrayByParity(int[] A) {
		int[] op = new int[A.length];
		int i = 0;
		int j = A.length - 1;

		for (int num : A) {
			if (num % 2 == 0) {
				op[i++] = num;
			} else {
				op[j--] = num;
			}
		}
		return op;
	}
}
