package leetcode.easy;

public class Prob392_IsSubSequence {

	public static void main(String[] args) {
		System.out.println(isSubsequence("abcd", "xabcdefg"));
	}

	static public boolean isSubsequence(String s, String t) {

		if (s == null || s.length() == 0) {
			return true;
		}
		if (s.length() > t.length()) {
			return false;
		}

		int sPtr = 0;
		int tPtr = 0;

		int sLen = s.length();
		int tLen = t.length();

		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();

		while (sPtr < sLen && tPtr < tLen) {
			if (sArr[sPtr] != tArr[tPtr]) {
				tPtr++;
			} else {
				sPtr++;
				tPtr++;
			}
		}
		return sPtr == sLen && tPtr <= tLen;

	}
}
