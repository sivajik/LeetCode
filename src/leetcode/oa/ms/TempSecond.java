package leetcode.oa.ms;

public class TempSecond {

	public static void main(String[] args) {
		System.out.println(solution("abccbd", new int[] { 0, 1, 2, 3, 4, 5 }));
		System.out.println(solution("aabbcc", new int[] { 1, 2, 1, 2, 1, 2 }));
		System.out.println(solution("aaaa", new int[] { 3, 4, 5, 6 }));
		System.out.println(solution("ababa", new int[] { 10, 5, 10, 5, 10 }));

	}

	static public int solution(String S, int[] C) {
		int totalCost = 0;
		char chars[] = S.toCharArray();

		// one loop of O(n) should do this.
		// initially set prev as zero (first elem)
		int prev = 0;
		int startAt = 1;
		for (int i = startAt; i < chars.length; i++) {
			if (chars[prev] != chars[i]) {
				prev = i;
			} else {
				// prev and curr character are same.
				// violating "same character next to each other" case
				// if prev cost is less than curr cost then use it.
				if (C[prev] < C[i]) {
					totalCost += C[prev];
					prev = i;
				} else {
					// else curr is minimum cost than prev, so use it
					totalCost += C[i];
				}
			}
		}
		return totalCost;
	}
}
