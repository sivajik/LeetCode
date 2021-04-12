package leetcode.hard;

import java.util.Stack;

public class Prob591_TagValidator {

	public static void main(String[] args) {
		System.out.println(isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
	}

	static Stack<String> stk = new Stack<>();
	static boolean containsTag = false;

	static public boolean isValid(String code) {
		if (code.charAt(0) != '<' || code.charAt(code.length() - 1) != '>') {
			return false;
		}

		for (int i = 0; i < code.length(); i++) {
			int closeIndex;
			boolean ending = false;

			if (stk.isEmpty() && containsTag) {
				return false;
			}
			
			if (code.charAt(i) == '<') {
				if (!stk.isEmpty() && code.charAt(i + 1) == '!') {
					closeIndex = code.indexOf("]]>", i + 1);
					if (closeIndex < 0 || !isValidCdata(code.substring(i + 2, closeIndex))) {
						return false;
					}
				} else {
					if (code.charAt(i + 1) == '/') {
						i++;
						ending = true;
					}
					closeIndex = code.indexOf('>', i + 1);
					if (closeIndex < 0 || !isValidTagName(code.substring(i + 1, closeIndex), ending)) {
						return false;
					}
				}
				i = closeIndex;// advance i
			}
		}
		return stk.isEmpty() && containsTag;
	}

	private static boolean isValidTagName(String s, boolean ending) {
		// shd be 1-9 characters
		if (s.length() < 1 || s.length() > 9) {
			return false;
		}
		// all uppercase
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isUpperCase(s.charAt(i))) {
				return false;
			}
		}

		if (ending) { // ending tag, make sure opening existed.
			if (!stk.isEmpty() && stk.peek().equals(s)) {
				stk.pop();
			} else {
				return false;
			}
		} else {
			containsTag = true;
			stk.push(s);
		}
		return true;
	}

	private static boolean isValidCdata(String s) {
		return s.indexOf("[CDATA[") == 0;
	}
}
