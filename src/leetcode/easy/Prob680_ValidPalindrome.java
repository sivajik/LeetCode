package leetcode.easy;

public class Prob680_ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(validPalindrome("aba"));
		System.out.println(validPalindrome("abca"));
		System.out.println(validPalindrome("abccba"));
		System.out.println(validPalindrome(
				"aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
	}

	public static boolean validPalindrome(String s) {
		if (s.length() <= 2) {
			return true;
		}

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return palin(s, start + 1, end) || palin(s, start, end - 1);
			} else {
				start++;
				end--;
			}
		}
		return true;
	}

	public static boolean palin(String s, int start, int end) {
		int left = start;
		int right = end;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}
		return true;
	}
}
