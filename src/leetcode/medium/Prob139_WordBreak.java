package leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prob139_WordBreak {

	public static void main(String[] args) {
		System.out.println(wordBreak("leetcode", Arrays.asList(new String[] { "leet", "code" })));
	}

	static public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> set = new HashSet<>(wordDict);
		int n = s.length();

		boolean[] dp = new boolean[n + 1];
		dp[0] = true;

		for (int len = 1; len <= n; len++) {
			System.out.println("Len: " + len);
			for (int i = 0; i < len; i++) {
				String temp = s.substring(i, len);
				System.out.println("Checking : " + temp);
				if (dp[i] && set.contains(temp)) {
					dp[len] = true;
				}
			}
		}
		return dp[n];
	}
}