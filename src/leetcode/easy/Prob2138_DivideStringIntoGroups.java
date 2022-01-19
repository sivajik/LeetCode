package leetcode.easy;

import java.util.Arrays;

public class Prob2138_DivideStringIntoGroups {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(divideString("abcdefghi", 3, 'x')));
		System.out.println(Arrays.toString(divideString("abcdefghij", 3, 'x')));
	}

	static public String[] divideString(String s, int k, char fill) {
		int len = s.length();
		if (len % k != 0) {
			StringBuilder sbr = new StringBuilder();
			for (int i = 0; i < k - (len % k); i++) {
				sbr.append(fill);
			}
			s = s + sbr.toString();
		}
		String[] op = new String[s.length() / k];
		for (int i = 0, j = 0; j < s.length() / k; i += k) {
			String sub = s.substring(i, i + k);
			op[j++] = sub;
		}
		return op;
	}
}
