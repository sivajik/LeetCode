package leetcode.medium;

public class Prob5_LongestPalindromicSubstring {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("racecar"));
	}

	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}

		int start = 0;
		int end = 0;
		for (int i = 0; i < s.length(); i++) {
			int l1 = expand(s, i, i); // racecar
			int l2 = expand(s, i, i + 1); // aabbaa
			int l = Math.max(l1, l2);

			if (l > end - start) {
				start = i - ((l - 1) / 2);
				end = i + (l / 2);
			}
		}
		return s.substring(start, end + 1);
	}

	static public int expand(String s, int left, int right) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

}
