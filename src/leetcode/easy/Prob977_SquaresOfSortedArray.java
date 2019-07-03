package leetcode.easy;

import java.util.Arrays;

public class Prob977_SquaresOfSortedArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));

	}

	public static int[] sortedSquares(int[] A) {
		return Arrays.stream(A).map((x) -> (x * x)).sorted().toArray();
	}
}
