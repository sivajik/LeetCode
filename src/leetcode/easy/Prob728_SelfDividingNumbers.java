package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class Prob728_SelfDividingNumbers {

	public static void main(String[] args) {
		int left = 1;
		int right = 10000;
		List<Integer> list = selfDividingNumbers(left, right);
		for (Integer i : list) {
			System.out.print(i + " ");
		}
	}

	public static List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> result = new ArrayList<Integer>();

		for (int i = left; i <= right; i++) {
			String strNumber = String.valueOf(i);
			if (strNumber.indexOf('0') != -1) {
				continue; // unfit to be self dividing number
			} else {
				char[] tokens = strNumber.toCharArray(); // 1 2 8
				boolean allPass = true;
				for (char token : tokens) {
					if (i % (token - 48) != 0) {
						allPass = false;
						break;
					}
				}
				if (allPass) {
					result.add(i);
				}
			}
		}

		return result;
	}
}
