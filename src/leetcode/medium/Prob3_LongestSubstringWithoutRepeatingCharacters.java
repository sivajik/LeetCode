package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Prob3_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb") == 3);
		System.out.println(lengthOfLongestSubstring("bbbbbb") == 1);
		System.out.println(lengthOfLongestSubstring("pwwkew") == 3);
	}

	static public int lengthOfLongestSubstring(String s) {
		int aPointer = 0;
		int bPointer = 0;
		int n = s.length();

		int count = 0;
		Set<Character> set = new HashSet<>();
		while (aPointer < n && bPointer < n) {
			char lookFor = s.charAt(bPointer);
			if (set.contains(lookFor)) {
				set.remove(s.charAt(aPointer));
				aPointer++;
			} else {
				set.add(lookFor);
				bPointer++;
				count = Math.max(count, set.size());
			}
		}
		return count;
	}
}
