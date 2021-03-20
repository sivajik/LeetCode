package leetcode.medium;

import java.util.Arrays;
import java.util.List;

public class Prob1239_MaxLenConcStrUniqChars {

	public static void main(String[] args) {
		System.out.println(maxLength(Arrays.asList(new String[] { "ab", "ba", "cd", "dc", "ef", "fe", "gh", "hg", "ij",
				"ji", "kl", "lk", "mn", "nm", "op", "po" })));
		System.out.println(maxLength(Arrays.asList(new String[] { "un", "iq", "ue" })));
		System.out.println(maxLength(Arrays.asList(new String[] { "cha", "r", "act", "ers" })));
		System.out.println(maxLength(Arrays.asList(new String[] { "abcdefghijklmnopqrstuvwxyz" })));

	}

	static int maxLength = Integer.MIN_VALUE;

	static public int maxLength(List<String> arr) {
		dfs(arr, 0, 0, new boolean['z' - 'a' + 1]);
		return maxLength;
	}

	static private void dfs(List<String> arr, int idx, int wordLength, boolean[] letters) {
		maxLength = Math.max(maxLength, wordLength);
		for (int i = idx; i < arr.size(); i++) {
			String str = arr.get(i);
			boolean[] lettersTmp = Arrays.copyOf(letters, letters.length);
			if (verifyString(str, lettersTmp))
				dfs(arr, i + 1, wordLength + str.length(), lettersTmp);
		}
	}

	static private boolean verifyString(String s1, boolean[] letters) {
		for (char s : s1.toCharArray()) {
			if (letters['z' - s])
				return false;
			else
				letters['z' - s] = true;
		}
		return true;
	}

	static public int maxLength1(List<String> arr) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.size(); i++) {
			StringBuilder sbr = new StringBuilder(arr.get(i));
			if (allUnique1(arr.get(i))) {
				max = Math.max(max, arr.get(i).length());
			}
			for (int j = 0; j < arr.size(); j++) {
				sbr.append(arr.get(j));
				if (allUnique1(sbr.toString())) {
					max = Math.max(max, sbr.length());
				} else {
					sbr.delete(sbr.length() - arr.get(j).length(), sbr.length());
				}
			}
		}
		return max == Integer.MIN_VALUE ? 0 : max;
	}

	static public boolean allUnique1(String s) {
		// System.out.println("Checking: " + s);
		int[] cnts = new int[26];
		for (char c : s.toCharArray()) {
			if (cnts[c - 'a'] > 0) {
				return false;
			} else {
				cnts[c - 'a']++;
			}
		}
		return true;
	}
}
