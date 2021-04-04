package leetcode.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Prob819_MostCommonWord {

	public static void main(String[] args) {
		System.out.println(
				mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] { "hit" }));
	}

	static public String mostCommonWord(String paragraph, String[] banned) {
		String normStr = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
		String[] tokens = normStr.split("\\s+");

		Set<String> banendWords = new HashSet<>();
		for (String bann : banned) {
			banendWords.add(bann.toLowerCase());
		}

		Map<String, Integer> map = new HashMap<>();
		for (String eachToken : tokens) {
			if (!banendWords.contains(eachToken)) {
				map.put(eachToken, 1 + map.getOrDefault(eachToken, 0));
			}
		}

		return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
}
