package leetcode.g5.easy;

public class Prob1844_ReplaceAllDigitsWithCharacters {

	public static void main(String[] args) {
		System.out.println(replaceDigits("a1c1e1").equals("abcdef"));
		System.out.println(replaceDigits("a1b2c3d4e").equals("abbdcfdhe"));
	}

	static public String replaceDigits(String s) {
		char[] c = s.toCharArray();

		for (int i = 1; i < s.length(); i += 2) {
			c[i] = shift(c[i - 1], c[i] - '0');
		}
		return new String(c);
	}

	static public char shift(char a, int b) {
		return (char) ((int) a + b);
	}
}
