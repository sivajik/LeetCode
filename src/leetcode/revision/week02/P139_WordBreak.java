package leetcode.revision.week02;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class P139_WordBreak {

	public static void main(String[] args) {
		System.out.println(wordBreak("catsandog", Arrays.asList(new String[] { "cat", "cats", "sand", "and", "dog" })));
	}

	static public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);

		Queue<Integer> q = new LinkedList<>();
		q.add(0);

		boolean[] visited = new boolean[s.length()];

		while (!q.isEmpty()) {
			int start = q.poll();
			if (visited[start] == false) {
				for (int end = start + 1; end <= s.length(); end++) {
					String word = s.substring(start, end);
					// System.out.println("Testing word: " + word);
					if (set.contains(word)) {
						// System.out.println("\t found: " + word);
						q.add(end);
						if (end == s.length()) {
							return true;
						}
					}
				}
				visited[start] = true;
			}
		}
		return false;
	}
}
