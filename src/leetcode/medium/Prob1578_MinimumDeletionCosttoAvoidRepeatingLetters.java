package leetcode.medium;

public class Prob1578_MinimumDeletionCosttoAvoidRepeatingLetters {

	public static void main(String[] args) {
		System.out.println(minCost("abaac", new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(minCost("abc", new int[] { 1, 2, 3 }));
		System.out.println(minCost("aabaa", new int[] { 1, 2, 3, 4, 1 }));
		System.out.println(minCost("aaabbbabbbb", new int[] { 3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1 }));
	}

	static public int minCost(String s, int[] cost) {
		int prevIndex = 0;

		int total = 0;
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) != s.charAt(prevIndex)) {
				prevIndex = i;
			} else {
				// matching
				if (cost[prevIndex] < cost[i]) {
					total += cost[prevIndex];
					// we deleted prev
					prevIndex = i;
				} else {
					total += cost[i];
				}

			}
		}
		return total;
	}
}
