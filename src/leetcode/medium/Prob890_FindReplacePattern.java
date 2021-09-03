package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob890_FindReplacePattern {

	public static void main(String[] args) {
		List<String> re = findAndReplacePattern(new String[] { "abc", "deq", "mee", "aqq", "dkd", "ccc" }, "abb");
		for (String s : re) {
			System.out.println(s);
		}
	}

	static public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> result = new ArrayList<>();

		for (String eachWord : words) {
			if (isPatternsAccepted(eachWord, pattern)) {
				result.add(eachWord);
			}
		}
		return result;
	}

	static private boolean isPatternsAccepted(String eachWord, String pattern) {
		// pattern = "abb"
		// string = "mee"
		if (pattern.length() != eachWord.length()) {
			return false;
		}

		Map<Character, Character> mapPattern2Str = new HashMap<>();
		Map<Character, Character> string2Pattern = new HashMap<>();

		for (int i = 0; i < pattern.length(); i++) {
			char patternChar = pattern.charAt(i);
			char wordChar = eachWord.charAt(i);

			if (!mapPattern2Str.containsKey(patternChar) && !string2Pattern.containsKey(wordChar)) {
				mapPattern2Str.put(patternChar, wordChar);
				string2Pattern.put(wordChar, patternChar);
			} else {
				if (mapPattern2Str.containsKey(patternChar)) {
					if( mapPattern2Str.get(patternChar) != wordChar) {
						return false;
					}
				}
				
				if (string2Pattern.containsKey(wordChar)) {
					if (string2Pattern.get(wordChar) != patternChar) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
