package leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob1153_StringTransformsIntoAnotherString {

	public static void main(String[] args) {
		System.out.println(canConvert("leetcode", "codeleet"));
		System.out.println(canConvert("aabcc", "ccdee"));
	}

	static public boolean canConvert(String str1, String str2) {
		if (str1 == null || str2 == null) {
			return false;
		}
		if (str1.length() != str2.length()) {
			return false;
		}

		if (str1.equals(str2)) {
			return true;
		}

		Map<Character, Character> m1 = new HashMap<>();
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < str1.length(); i++) {
			char a = str1.charAt(i);
			char b = str2.charAt(i);

			if (m1.get(a) != null && m1.get(a) != b) {
				return false;
			}
			m1.put(a, b);
			set.add(b);
		}

		if (m1.size() == 26 && set.size() == 26) {
			return false;
		}
		return true;
	}
}
