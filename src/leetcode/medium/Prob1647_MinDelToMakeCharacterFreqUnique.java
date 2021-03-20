package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class Prob1647_MinDelToMakeCharacterFreqUnique {

	public static void main(String[] args) {
		System.out.println(minDeletions("ceabaacb"));

	}

	static public int minDeletions(String s) {
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}
		Set<Integer> set = new HashSet<>();
		int del = 0;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] != 0 && set.contains(freq[i])) {
				freq[i]--;
				del++;
			}
			set.add(freq[i]);
		}
		return del;
	}
}
