package leetcode.easy;

import java.util.*;

public class Prob266_PalindromePermutation {

	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("code"));
		System.out.println(canPermutePalindrome("aab"));
		System.out.println(canPermutePalindrome("carerac"));
	}

	static public boolean canPermutePalindrome(String s) {
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (set.contains(c)) {
				set.remove(c);
			} else {
				set.add(c);
			}
		}
		return set.size() <= 1;
	}
}
