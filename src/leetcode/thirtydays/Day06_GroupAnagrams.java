package leetcode.thirtydays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day06_GroupAnagrams {

	public static void main(String[] args) {
		System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
	}

	// brute force appraoch.
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, ArrayList<String>> map = new HashMap();

		for (String str : strs) {
			char[] sortedStr = str.toCharArray();
			Arrays.sort(sortedStr);
			String sortedString = new String(sortedStr);

			if (map.containsKey(sortedString)) {
				ArrayList<String> l = map.get(sortedString);
				l.add(str);
				map.put(sortedString, l);
			} else {
				ArrayList<String> l = new ArrayList<String>();
				l.add(str);
				map.put(sortedString, l);
			}
		}
		java.util.Collection<ArrayList<String>> coll = map.values();
		return new ArrayList<>(coll);
	}

	// not used
	public boolean areAnagrams(String s1, String s2) {
		Map<Character, Integer> map = new HashMap();
		for (char c : s1.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, 1 + map.get(c));
			} else {
				map.put(c, 1);
			}
		}

		for (char c : s1.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0) {
					map.remove(c);
				}
			} else {
				return false;
			}
		}
		return map.size() == 0;
	}
}
