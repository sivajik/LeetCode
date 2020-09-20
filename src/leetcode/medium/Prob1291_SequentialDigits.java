package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prob1291_SequentialDigits {

	public static void main(String[] args) {
		System.out.println(sequentialDigits(100, 300));
		System.out.println(sequentialDigits(1000, 13000));
	}

	static public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> l = new ArrayList<>();
		for (int possibleDigit = 1; possibleDigit <= 9; possibleDigit++) {
			solve(l, low, high, 0, possibleDigit);
		}
		Collections.sort(l);
		return l;
	}

	private static void solve(List<Integer> l, int low, int high, int sum, int digitValue) {
		sum = (sum * 10) + digitValue;
		if (sum > high) {
			return;
		}
		if (sum >= low) {
			l.add(sum);
			// return;
		}
		if (digitValue + 1 <= 9) {
			solve(l, low, high, sum, digitValue + 1);
		}
	}

	private static int getNumber(List<Integer> arr, int startIndex) {
		int sum = 0;
		for (int i = 0; i < startIndex; i++) {
			sum = (sum * 10) + arr.get(i);
		}
		return sum;
	}
}