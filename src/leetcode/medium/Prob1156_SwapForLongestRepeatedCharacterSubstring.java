package leetcode.medium;

import java.util.TreeMap;

public class Prob1156_SwapForLongestRepeatedCharacterSubstring {

	public static void main(String[] args) {
		// System.out.println(maxRepOpt1("ababa"));
		// System.out.println(maxRepOpt1("abcdef"));
		System.out.println(maxRepOpt1("bbababaaaa"));
		
	}

	static public int maxRepOpt1(String text) {
		int[] counts = new int[26];
		for (char c : text.toCharArray()) {
			counts[c - 'a']++;
		}

		TreeMap<Character, Integer> map = new TreeMap<>();
		int i = 0;
		int result = 1; // ??
		for (int j = 0; j < text.length(); j++) {

			char cj = text.charAt(j);

			if (!map.containsKey(cj)) {
				map.put(cj, 1);
			} else {
				map.put(cj, 1 + map.get(cj));
			}

			// The following two cases do not qualify the requirement.
			// 1. There are more than two different chars.
			// 2. The minimum occurrence counts of two different chars are bigger than one.
			while (map.size() > 2
					|| (map.size() == 2 && Math.min(map.firstEntry().getValue(), map.lastEntry().getValue()) > 1)) {
				char ci = text.charAt(i); // get the first char i.e. ith and swap (so it will be removed)
				int cnt = map.get(ci) - 1; // very critical to keep -1 here.

				if (cnt == 0) {
					map.remove(ci);
				} else {
					map.put(ci, cnt);
				}

				i++;
			}

			if (map.size() == 2) {
				if (map.firstEntry().getValue() == 1) {
					int otherCharIndex = map.lastEntry().getKey() - 'a';
					if (counts[otherCharIndex] > map.lastEntry().getValue()) {
						result = Math.max(result, j - i + 1);
					}
				}

				if (map.lastEntry().getValue() == 1) {
					int otherCharIndex = map.firstEntry().getKey() - 'a';
					if (counts[otherCharIndex] > map.firstEntry().getValue()) {
						result = Math.max(result, j - i + 1);
					}
				}
			} else {
				result = Math.max(result, j - i + 1);
			}
		}
		return result;
	}
}
