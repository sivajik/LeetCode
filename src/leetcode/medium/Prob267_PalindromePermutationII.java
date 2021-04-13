package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob267_PalindromePermutationII {

	public static void main(String[] args) {
		System.out.println(generatePalindromes("aabb"));

	}

	static public List<String> generatePalindromes(String s) {
		int n = s.length();
		int[] counter = new int[128];

		for (char c : s.toCharArray()) {
			counter[c]++;
		}

		int odd = 0;
		char oddChar = '\0';
		for (int i = 0; i < 128; i++) {
			if (counter[i] % 2 == 1) {
				odd++;
				oddChar = (char) i;
			}
		}

		if (odd > 1) {
			return new ArrayList<>(); // cant make palindromes;
		}

		char[] path = new char[n];
		if (oddChar != '\0') {
			path[n / 2] = oddChar; // place odd char in middle
			counter[oddChar]--;
		}
		List<String> res = new ArrayList<>();
		permute(res, counter, path, 0, n - 1);
		return res;
	}

	private static void permute(List<String> res, int[] counter, char[] path, int start, int end) {
		if (start >= end) {
			res.add(new String(path));
			return;
		}

		for (int i = 0; i < 128; i++) {
			if (counter[i] == 0) {
				continue;
			}

			counter[i] -= 2;
			path[start] = (char) i;
			path[end] = (char) i;
			permute(res, counter, path, start + 1, end - 1);
			counter[i] += 2;
		}
	}

}
