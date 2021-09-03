package leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob269_AlienDictionary {

	public static void main(String[] args) {
		System.out.println(alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
		/*	System.out.println(alienOrder(new String[] { "z", "x" }));
		System.out.println(alienOrder(new String[] { "z", "x", "z" }));
		System.out.println(alienOrder(new String[] { "ac", "ab", "zc", "zb" }));*/
	}

	public static String alienOrder(String[] words) {
		Map<Character, List<Character>> g = new HashMap<>();

		for (String word : words) {
			for (char c : word.toCharArray()) {
				if (!g.containsKey(c)) {
					g.put(c, new ArrayList<>());
				}
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String word1 = words[i];
			String word2 = words[i + 1];
			// 121/122 passes with out this.
			if (word1.length() > word2.length() && word1.startsWith(word2)) {
				return "";
			}

			for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
				char u = word1.charAt(j);
				char v = word2.charAt(j);
				if (u != v) {
					g.get(u).add(v);
					//with out break you keep doing 4th input as blank output.
					break;
				}
			}
		}

		Map<Character, Boolean> visited = new HashMap<>();
		List<Character> op = new ArrayList<>();
		for (Character at : g.keySet()) {
			boolean cycle = dfs(at, visited, g, op);
			if (cycle) {
				return "";
			}
		}
		if (op.size() < g.size()) {
			return "";
		}
		StringBuilder sbr = new StringBuilder();
		for (Character c : op) {
			sbr.append(c);
		}
		return sbr.toString();
	}

	// return if loop exists
	private static boolean dfs(Character c, Map<Character, Boolean> seen, Map<Character, List<Character>> g,
			List<Character> op) {
		if (seen.containsKey(c)) {
			return seen.get(c) == true ? true : false;
		}
		seen.put(c, true);
		for (Character next : g.get(c)) {
			boolean cycle = dfs(next, seen, g, op);
			if (cycle) {
				return true;
			}
		}
		seen.put(c, false);
		op.add(0, c);
		return false; // finally here, no cycle then.
	}
}
