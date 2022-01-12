package leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob893_GroupsSpecialEquivalentStrings {

	public static void main(String[] args) {
		System.out.println(numSpecialEquivGroups(new String[] { "abcd", "cdab", "cbad", "xyzz", "zzxy", "zzyx" }));
		System.out.println(numSpecialEquivGroups(new String[] { "abc", "acb", "bac", "bca", "cab", "cba" }));
		System.out.println(numSpecialEquivGroups(new String[] { "ababaa", "aaabaa" }));
	}

	static public int numSpecialEquivGroups(String[] words) {
		Map<String, Integer> res = new HashMap<>();
		for (String word : words) {
			char[] temp = word.toCharArray();
			List<Character> evenSet = new ArrayList<>();
			List<Character> oddSet = new ArrayList<>();

			for (int i = 0; i < temp.length; i++) {
				if (i % 2 == 0) {
					evenSet.add(temp[i]);
				} else {
					oddSet.add(temp[i]);
				}
			}

			Collections.sort(evenSet);
			Collections.sort(oddSet);

			StringBuilder sbr = new StringBuilder();
			for (char c : evenSet) {
				sbr.append(c);
			}
			for (char c : oddSet) {
				sbr.append(c);
			}
			// System.out.println(sbr);
			if (!res.containsKey(sbr.toString())) {
				res.put(sbr.toString(), 1);
			}
		}
		return res.size();
	}
}
