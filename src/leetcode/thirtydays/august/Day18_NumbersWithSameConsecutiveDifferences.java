package leetcode.thirtydays.august;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day18_NumbersWithSameConsecutiveDifferences {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(numsSameConsecDiff(3, 7)));
		System.out.println();
		System.out.println(Arrays.toString(numsSameConsecDiff(2, 1)));
		System.out.println();
		System.out.println(Arrays.toString(numsSameConsecDiff(1, 0)));
	}

	static public int[] numsSameConsecDiff(int N, int K) {
		if (N == 1) {
			return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		}
		int[] tempArray = new int[N];
		List<Integer> res = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			tempArray[0] = i;
			solve(N, K, tempArray, 1, res);
		}

		int[] r = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			r[i] = res.get(i);
		}
		return r;
	}

	static private void solve(int n, int k, int[] tempArray, int currIndex, List<Integer> res) {
		if (currIndex == n) {
			res.add(makeNumbers(tempArray));
			return;
		}

		for (int possibleNumber = 0; possibleNumber <= 9; possibleNumber++) {
			if (Math.abs(possibleNumber - tempArray[currIndex - 1]) == k) {
				tempArray[currIndex] = possibleNumber;
				solve(n, k, tempArray, currIndex + 1, res);
			}
		}
	}

	private static Integer makeNumbers(int[] tempArray) {
		int sum = 0;
		for (int i = 0; i < tempArray.length; i++) {
			sum = (sum * 10) + tempArray[i];
		}
		return sum;
	}
}
