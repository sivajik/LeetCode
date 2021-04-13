package leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Prob140_WordBreak2 {
	public static void main(String[] a) {
		System.out
				.println(wordBreak("catsanddog", Arrays.asList(new String[] { "cat", "cats", "and", "sand", "dog" })));
	}

	static final Map<String, List<String>> cache = new HashMap<>();

	static public List<String> wordBreak(String s, List<String> wordDict) {
		if (cache.containsKey(s)) {
			return cache.get(s);
		}

		List<String> result = new LinkedList<>();
		if (wordDict.contains(s)) {
			result.add(s);
		}
		for (int i = 1; i < s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i);
			if (wordDict.contains(left) ) { //&& containsSuffix(wordDict, right)) {
				for (String ss : wordBreak(right, wordDict)) {
					result.add(left + " " + ss);
				}
			}
		}
		cache.put(s, result);
		return result;
	}
/*
	private static boolean containsSuffix(List<String> wordDict, String s) {
		for (int i = 0; i < s.length(); i++) {
			if (wordDict.contains(s.substring(i))) {
				return true;
			}
		}
		return false;
	}
*/	
}
