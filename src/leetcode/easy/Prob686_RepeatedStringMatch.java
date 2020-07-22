package leetcode.easy;

public class Prob686_RepeatedStringMatch {

	public static void main(String[] args) {
		System.out.println(repeatedStringMatch("abcd", "cdabcdab"));
	}

	static public int repeatedStringMatch(String A, String B) {
		StringBuilder sbr = new StringBuilder(A);

		int c = 1;
		while (sbr.length() < B.length()) {
			sbr.append(A);
			c++;
		}

		if (sbr.indexOf(B) >= 0) {
			return c;
		}
		if (sbr.append(A).indexOf(B) >= 0) {
			return c + 1;
		}
		return -1;
	}
}
