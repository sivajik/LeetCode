package leetcode.easy;

public class Prob520_DetectCapiral {

	public static void main(String[] args) {
		System.out.println(detectCapitalUse("USA"));
		System.out.println(detectCapitalUse("FlaG"));
		System.out.println(detectCapitalUse("abcd"));
		System.out.println(detectCapitalUse("Google"));

	}

	public static boolean detectCapitalUse(String s) {
		return s.equals(s.toLowerCase()) || s.equals(s.toUpperCase())
				|| (s.charAt(0) == s.toUpperCase().charAt(0) && s.substring(1).equals(s.toLowerCase().substring(1)));
	}
}
