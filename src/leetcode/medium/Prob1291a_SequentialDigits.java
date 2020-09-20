package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob1291a_SequentialDigits {

	public static void main(String[] args) {
		System.out.println(sequentialDigits(100, 300));
		System.out.println(sequentialDigits(1000, 13000));
	}

	static public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> l = new ArrayList<>();
		for (int possibleDigit = 1; possibleDigit <= 9; possibleDigit++) {
			solve(l, low, high, possibleDigit, 0, new ArrayList<>());
		}
		Collections.sort(l);
		return l;
	}

	private static void solve(List<Integer> l, int low, int high, int possibleDigit, int currIndex,
			List<Integer> arr) {

		int sum = getNumber(arr, currIndex);

		if (sum > high) {
			return;
		}
		if (sum >= low) {
			l.add(sum);
			// return;
		}

		arr.add(currIndex, possibleDigit);
		solve(l, low, high, possibleDigit + 1, currIndex + 1, arr);
		arr.remove(arr.size() - 1);
	}

	private static int getNumber(List<Integer> arr, int startIndex) {
		int sum = 0;
		for (int i = 0; i < startIndex; i++) {
			if (arr.get(i) > 9) {
				return Integer.MAX_VALUE;
			}
			sum = (sum * 10) + arr.get(i);
		}
		return sum;
	}
}