package leetcode.easy;

public class Prob1332_RemovePalindromicSubsequences {

	public static void main(String[] args) {
		System.out.println(removePalindromeSub("ababa"));
		System.out.println(removePalindromeSub("abb"));
		System.out.println(removePalindromeSub("baabb"));
	}

	public static int removePalindromeSub(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		if (isPalin(s)) {
			return 1;
		}
		return 2;
	}

	private static boolean isPalin(String s) {
		int i = 0, j = s.length() -1;
		while (i < j) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
