package leetcode.thirtydays.july21;

import java.util.HashMap;
import java.util.Map;

public class Day12_IsomorphicStrings {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("paper", "title"));
		System.out.println(isIsomorphic("badc", "baba"));
	}

	static public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		java.util.Set<Character> set = new java.util.HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if (map.containsKey(c1)) {
				if (map.get(c1) != c2) {
					return false;
				}
			} else {
				if (set.contains(c2)) {
					return false;
				} else {
					map.put(c1, c2);
					set.add(c2);
				}
			}
		}
		return true;
	}
}