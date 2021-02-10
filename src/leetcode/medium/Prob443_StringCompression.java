package leetcode.medium;

public class Prob443_StringCompression {

	public static void main(String[] args) {
		System.out.println(compress(new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' }));
		System.out.println(compress(new char[] { 'a' }));
		System.out.println(compress(new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' }));
		System.out.println(compress(new char[] { 'a', 'a', 'a', 'b', 'b', 'a', 'a' }));
	}

	static public int compress(char[] chars) {
		StringBuilder sbr = new StringBuilder();
		char prevChar = chars[0];
		int count = 1;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] == prevChar) {
				count++;
			} else {
				if (count == 1) {
					sbr.append(prevChar);
				} else {
					sbr.append(prevChar);
					sbr.append(count);
				}
				count = 1;
			}
			prevChar = chars[i];
		}
		if (count > 1) {
			sbr.append(prevChar);
			sbr.append(count);
		} else {
			sbr.append(prevChar);
		}
		String s = sbr.toString();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			chars[i] = s.charAt(i);
		}
		return len;
	}
}
