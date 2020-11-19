package leetcode.revision.week01.medium;

import java.util.*;

public class P394_DecodeString {

	public static void main(String[] args) {

		System.out.println(decodeString("3[a]2[bc]").equalsIgnoreCase("aaabcbc"));
		System.out.println(decodeString("3[a2[c]]").equals("accaccacc"));
		System.out.println(decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef"));
		System.out.println(decodeString("abc3[cd]xyz").equals("abccdcdcdxyz"));

		System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef")
				.equals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"));
	}

	static public String decodeString(String s) {
		Stack<Integer> numStack = new Stack<>();
		Stack<String> stk = new Stack<>();
		stk.push("");

		for (int i = 0; i < s.length();) {
			char c = s.charAt(i);
			if (c == '[') {
				stk.push("");
				i++;
			} else if (c == ']') {
				StringBuilder sbr = new StringBuilder(stk.pop());
				int count = numStack.pop();
				StringBuilder cStr = new StringBuilder();
				for (int j = 0; j < count; j++) {
					cStr = cStr.append(sbr);
				}
				stk.push(stk.pop() + cStr.toString());
				i++;
			} else if (c >= '0' && c <= '9') {
				int number = 0;
				for (int j = i; s.charAt(j) != '['; j++, i++) {
					c = s.charAt(j);
					number = (number * 10) + (c - '0');
				}
				numStack.push(number);
			} else {
				stk.push(stk.pop() + c);
				i++;
			}
		}

		return stk.pop();
	}
}
//  	3[a]2[bc]
//		3[a2[c]]

// "zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"