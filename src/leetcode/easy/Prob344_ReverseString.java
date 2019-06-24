package leetcode.easy;

import java.util.Arrays;

public class Prob344_ReverseString {

	public static void main(String[] args) {
		reverseString(new char[] { 'h', 'e', 'l', 'l', 'o' });
		reverseString(new char[] { 'h' });
		reverseString(new char[] { 'h', 'e' });
		reverseString(new char[] {});
	}

	public static void reverseString(char[] s) {
		int n = s.length;
		for (int i = 0; i < n / 2; i++) {
			char temp = s[i];
			s[i] = s[n - i - 1];
			s[n - i - 1] = temp;
		}
		System.out.println(Arrays.toString(s));
	}

}
