package leetcode.thirtydays.august;

public class Day01_DetectCapital {

	public static void main(String[] args) {
		System.out.println(detectCapitalUse("USA"));
		System.out.println(detectCapitalUse("FlaG"));
		System.out.println(detectCapitalUse("abcd"));
		System.out.println(detectCapitalUse("Google"));
		System.out.println(detectCapitalUse("g"));
	}

	public static boolean stupidWay(String s) {
		return s.equals(s.toLowerCase()) || s.equals(s.toUpperCase())
				|| (s.charAt(0) == s.toUpperCase().charAt(0) && s.substring(1).equals(s.toLowerCase().substring(1)));
	}

	public static boolean detectCapitalUse(String s) {
		int capsCount = 0;
		int lowerCount = 0;
		int totalChars = s.length();
		boolean isInitCaps = false;
		char[] chars = s.toCharArray();

		if (chars[0] >= 'A' && chars[0] <= 'Z') {
			isInitCaps = true;
			capsCount++;
		}

		int start = isInitCaps ? 1: 0;
		
		for (int i = start; i < chars.length; i++) {
			char c = chars[i];
			if (c >= 'a' && c <= 'z') { 
				lowerCount++;
			} else if (c >= 'A' && c <= 'Z') {
				capsCount++;
			}
		}

		if (isInitCaps && (capsCount == 1 || capsCount == totalChars)) {
			return true;
		}
		if (!isInitCaps && lowerCount == totalChars) {
			return true;
		}
		return false;
	}
}
