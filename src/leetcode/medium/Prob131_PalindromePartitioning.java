package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob131_PalindromePartitioning {

	public static void main(String[] args) {
		for (List<String> l : partition("aab")) {
			System.out.println(l);
		}
	}

	static public List<List<String>> partition(String s) {
		List<List<String>> l = new ArrayList<>();
		helper(l, s, 0, new ArrayList<>());
		return l;
	}

	private static void helper(List<List<String>> l, String s, int start, ArrayList<String> temp) {
		if (start == s.length()) {
			l.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (isPalindrome(s, start, i)) {
				temp.add(s.substring(start, i + 1));
				helper(l, s, i + 1, temp);
				temp.remove(temp.size() - 1);
			}
		}

	}

	static public boolean isPalindrome(String s, int low, int high) {
		while (low < high)
			if (s.charAt(low++) != s.charAt(high--))
				return false;
		return true;
	}
}
