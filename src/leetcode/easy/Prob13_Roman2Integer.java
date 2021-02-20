package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Prob13_Roman2Integer {

	public static void main(String[] args) {
		System.out.println(romanToInt("III"));
		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("IX"));
		System.out.println(romanToInt("LVIII"));
		System.out.println(romanToInt("MCMXCIV"));
		System.out.println(romanToInt("MDCXCV"));
	}

	static public int romanToInt(String s) {
		char[] sym = new char[] { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };
		int[] vals = new int[] { 1, 5, 10, 50, 100, 500, 1000 };

		Map<Character, Integer> priorities = new HashMap<>();
		for (int i = 0; i < sym.length; i++) {
			priorities.put(sym[i], i);
		}
		Map<Character, Integer> values = new HashMap<>();
		for (int i = 0; i < sym.length; i++) {
			values.put(sym[i], vals[i]);
		}

		if (s.length() == 1) {
			return values.get(s.charAt(0));
		}

		int processed = 0;
		int total = 0;
		for (int i = 0; i < s.length() - 1; i += 1) {
			char curr = s.charAt(i);
			char next = s.charAt(i + 1);
			// IV
			if (priorities.get(curr) < priorities.get(next)) {
				total += values.get(next) - values.get(curr);
				i++;
				processed += 2;
			} else {
				// III
				total += values.get(curr);
				processed += 1;
			}
		}

		if (processed == s.length()) {
			return total;
		} else {
			while (processed < s.length()) {
				total += values.get(s.charAt(processed++));
			}
			return total;
		}
	}
}
