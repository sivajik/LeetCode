package leetcode.revision.week03;

public class P686_RepeatedStringMatch {

	public static void main(String[] args) {
		System.out.println(repeatedStringMatch("abcd", "cdabcdab") == 3);
		System.out.println(repeatedStringMatch("a", "aa") == 2);
		System.out.println(repeatedStringMatch("a", "a") == 1);
		System.out.println(repeatedStringMatch("abc", "wxyz") == -1);
	}

	static public int repeatedStringMatch(String a, String b) {
		StringBuilder sbr = new StringBuilder(a);
		int c = 1;
		while (sbr.length() < b.length()) {
			sbr.append(a);
			c++;
		}

		if (sbr.indexOf(b) >= 0) {
			return c;
		}

		if (sbr.append(a).indexOf(b) >= 0) {
			return c + 1;
		}

		return -1;
	}
}
