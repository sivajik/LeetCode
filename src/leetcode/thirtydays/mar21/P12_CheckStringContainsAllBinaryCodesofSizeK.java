package leetcode.thirtydays.mar21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P12_CheckStringContainsAllBinaryCodesofSizeK {

	public static void main(String[] args) {
		System.out.println(hasAllCodes("00110110", 2));
		System.out.println(hasAllCodes("00110", 2));
		System.out.println(hasAllCodes("0110", 1));
		System.out.println(hasAllCodes("0110", 2));
		System.out.println(hasAllCodes("0000000001011100", 4));
	}

	static public boolean hasAllCodes(String s, int k) {
		Set<String> set = new HashSet<>();
		int required = (int) Math.pow(2, k);

		for (int i = k; i <= s.length() ; i++) {
			String str = s.substring(i-k, i);
			// System.out.println(str);
			if (!set.contains(str)) {
				set.add(str);
				required--;
				if (required == 0) {
					return true;
				}
			}
		}
		return false;
	}

	static public boolean hasAllCodes1(String s, int k) {
		int[] arr = new int[k];
		List<String> allPossStr = new ArrayList<>();
		helper(k, arr, 0, allPossStr);

		for (String str : allPossStr) {
			if (s.indexOf(str) == -1) {
				return false;
			}
		}

		return true;
	}

	private static void helper(int k, int[] arr, int currIndex, List<String> allPossStr) {
		if (currIndex == k) {
			StringBuilder s = new StringBuilder();
			for (int i : arr) {
				s.append(i);
			}
			allPossStr.add(s.toString());
			return;
		}

		arr[currIndex] = 0;
		helper(k, arr, currIndex + 1, allPossStr);
		arr[currIndex] = 1;
		helper(k, arr, currIndex + 1, allPossStr);
	}
}
