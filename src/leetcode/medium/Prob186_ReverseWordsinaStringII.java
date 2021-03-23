package leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class Prob186_ReverseWordsinaStringII {

	public static void main(String[] args) {
		reverseWords(new char[] { 't', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e' });
		reverseWords(new char[] { 'a' });
	}

	static public void reverseWords(char[] s) {
		int l = 0;
		int r = s.length - 1;

		while (l < r) {
			char c = s[l];
			s[l] = s[r];
			s[r] = c;
			l++;
			r--;
		}
		int start = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i] == ' ') {
				reverse(s, start, i - 1);
				start = i + 1;
			} else if (i == s.length - 1) {
				reverse(s, start, i);
			}
		}

		System.out.println(Arrays.toString(s));
	}

	static public void reverse(char[] s, int l, int r) {
		while (l < r) {
			char c = s[l];
			s[l] = s[r];
			s[r] = c;
			l++;
			r--;
		}
	}

	static public void reverseWords1(char[] s) {
		Stack<StringBuilder> stk = new Stack<>();
		StringBuilder temp = new StringBuilder();
		for (char c : s) {
			if (c != ' ') {
				temp.append(c);
			} else {
				stk.push(temp);
				temp = new StringBuilder();
			}
		}
		if (temp.length() > 0) {
			stk.push(temp);
		}

		StringBuilder sbr = new StringBuilder();

		while (!stk.isEmpty()) {
			StringBuilder x = stk.pop();
			sbr.append(x);
			sbr.append(" ");
		}
		int i = 0;
		System.out.println(sbr);
		for (char c : sbr.toString().trim().toCharArray()) {
			s[i++] = c;
		}
		System.out.println(Arrays.toString(s));
	}
}
