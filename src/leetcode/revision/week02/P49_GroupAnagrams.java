package leetcode.revision.week02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49_GroupAnagrams {

	public static void main(String[] args) {
		for (List<String> l : groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" })) {
			System.out.println(l);
		}
		for (List<String> l : groupAnagrams(new String[] { "" })) {
			System.out.println(l);
		}

		for (List<String> l : groupAnagrams(new String[] { "a" })) {
			System.out.println(l);
		}

	}

	static public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> m = new HashMap<>();

		for (String str : strs) {
			String h = hash(str);
			if (m.containsKey(h)) {
				List<String> l = m.get(h);
				l.add(str);
				m.put(h, l);
			} else {
				List<String> l = new ArrayList<>();
				l.add(str);
				m.put(h, l);
			}
		}
		List<List<String>> result = new ArrayList<>();
		for (List<String> l : m.values()) {
			result.add(l);
		}
		return result;

	}

	private static String hash(String str) {
		int[] freq = new int[26];
		for (char c : str.toCharArray()) {
			freq[c - 'a']++;
		}
		StringBuilder sbr = new StringBuilder();
		for (int i : freq) {
			sbr.append('^');
			sbr.append(i);
		}
		return sbr.toString();
	}
}
