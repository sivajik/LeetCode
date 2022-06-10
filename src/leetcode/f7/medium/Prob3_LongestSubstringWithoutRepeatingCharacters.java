package leetcode.f7.medium;

import java.util.HashSet;
import java.util.Set;

public class Prob3_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb") == 3);
		System.out.println(lengthOfLongestSubstring("bbbbb") == 1);
		System.out.println(lengthOfLongestSubstring("pwwkew") == 3);
	}

	static public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<Character>();

		int i = 0, j = 0;
		int n = s.length();
		int max = Integer.MIN_VALUE;
		while (i < n && j < n) {
			char lookFor = s.charAt(j);
			if (set.contains(lookFor)) {
				set.remove(s.charAt(i));
				i++;
			} else {
				set.add(lookFor);
				max = Math.max(max, set.size());
				j++;
			}
		}
		return max;
	}
}