package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob966_VowelSpellchecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static Set<String> words_perfect;
	static Map<String, String> words_cap;
	static Map<String, String> words_vow;

	static public String[] spellchecker(String[] wordlist, String[] queries) {
		words_perfect = new HashSet();
		words_cap = new HashMap();
		words_vow = new HashMap();

		for (String word : wordlist) {
			words_perfect.add(word);

			String wordlow = word.toLowerCase();
			words_cap.putIfAbsent(wordlow, word);

			String wordlowDV = devowel(wordlow);
			words_vow.putIfAbsent(wordlowDV, word);
		}

		String[] ans = new String[queries.length];
		int t = 0;
		for (String query : queries)
			ans[t++] = solve(query);
		return ans;
	}

	static public String solve(String query) {
		if (words_perfect.contains(query))
			return query;

		String queryL = query.toLowerCase();
		if (words_cap.containsKey(queryL))
			return words_cap.get(queryL);

		String queryLV = devowel(queryL);
		if (words_vow.containsKey(queryLV))
			return words_vow.get(queryLV);

		return "";
	}

	static public String devowel(String word) {
		StringBuilder ans = new StringBuilder();
		for (char c : word.toCharArray())
			ans.append(isVowel(c) ? '*' : c);
		return ans.toString();
	}

	static public boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}
}
