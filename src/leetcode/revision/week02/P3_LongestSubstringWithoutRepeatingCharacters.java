package leetcode.revision.week02;

import java.util.HashSet;
import java.util.Set;

public class P3_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb") == 3);
		System.out.println(lengthOfLongestSubstring("bbbbb") == 1);
		System.out.println(lengthOfLongestSubstring("pwwkew") == 3);
		System.out.println(lengthOfLongestSubstring("") == 0);
	}

	static public int lengthOfLongestSubstring(String s) {
		int max = 0;//Integer.MIN_VALUE;

		int i = 0, j = 0;
		int n = s.length();
		Set<Character> set = new HashSet<>();
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				max = Math.max(max, j - i);
			} else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		return max;
	}
}
