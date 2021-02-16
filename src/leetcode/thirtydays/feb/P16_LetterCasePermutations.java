package leetcode.thirtydays.feb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P16_LetterCasePermutations {

	public static void main(String[] args) {
		System.out.println(letterCasePermutation("a1b2"));
		System.out.println(letterCasePermutation("3z4"));
		System.out.println(letterCasePermutation("12345"));
		System.out.println(letterCasePermutation("C"));
		System.out.println(letterCasePermutation("LzYracpd"));
	}

	static public List<String> letterCasePermutation(String S) {
		Set<String> results = new HashSet<>();
		results.add(S);

		solver(S, results, /* startIndex= */ 0);
		return new ArrayList<>(results);
	}

	static private void solver(String s, Set<String> results, int i) {
		if (!results.contains(s)) {
			results.add(s);
		}

		if (i == s.length()) {
			return;
		}

		char[] chars = s.toCharArray();

		if (Character.isLetter(chars[i])) {
			char currChar = chars[i];
			chars[i] = Character.toUpperCase(currChar);
			solver(new String(chars), results, i + 1);

			chars[i] = Character.toLowerCase(currChar);
			solver(new String(chars), results, i + 1);
			chars[i] = currChar;
		} else {
			solver(s, results, i + 1);
		}
	}
}
