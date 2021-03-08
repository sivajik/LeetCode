package leetcode.thirtydays.mar21;

public class P08_RemovePalindromicSubsequences {

	public static void main(String[] args) {
		System.out.println(removePalindromeSub("abba"));

	}

	static public int removePalindromeSub(String s) {
		if (s.isEmpty()) {
			return 0;
		}
		String reversedString = new StringBuilder(s).reverse().toString();
		if (reversedString.equals(s)) {
			return 1;
		}
		return 2;
	}
}
