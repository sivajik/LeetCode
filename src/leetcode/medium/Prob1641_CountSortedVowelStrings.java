package leetcode.medium;

public class Prob1641_CountSortedVowelStrings {

	public static void main(String[] args) {
		System.out.println(countVowelStrings(1));
		System.out.println(countVowelStrings(2));
		System.out.println(countVowelStrings(50));
	}

	static public int countVowelStrings(int n) {
		helper(n, "");
		return sum;
	}

	static char[] array = { 'a', 'e', 'i', 'o', 'u' };

	static int sum = 0;
	
	private static void helper(int n, String currStr) {
		if (currStr.length() >= 1 && !sorted(currStr)) {
			return;
		}

		if (currStr.length() == n) {
			sum += 1;
			return;
		}

		for (int i = 0; i < 5; i++) {
			currStr = currStr + array[i];
			helper(n, currStr);
			currStr = currStr.substring(0, currStr.length() - 1);
		}
	}

	private static boolean sorted(String currStr) {
		char c = currStr.charAt(0);
		for (int i = 1; i < currStr.length(); i++) {
			if (c > currStr.charAt(i)) {
				return false;
			} else {
				c = currStr.charAt(i);
			}
		}
		return true;
	}
}
