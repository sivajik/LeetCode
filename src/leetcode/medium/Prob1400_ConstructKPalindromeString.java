package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Prob1400_ConstructKPalindromeString {

	public static void main(String[] args) {
		System.out.println(canConstruct("annabelle", 2));
		System.out.println(canConstruct("leetcode", 3));
		System.out.println(canConstruct("true", 4));
		System.out.println(canConstruct("cr", 7));
	}

	static public boolean canConstruct(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, 1 + map.get(c));
			} else {
				map.put(c, 1);
			}
		}

		int odds = 0;
		for (int freq : map.values()) {
			if (freq % 2 == 1) {
				odds++;
			}
		}

		return s.length() >= k && odds <= k;
	}
}
