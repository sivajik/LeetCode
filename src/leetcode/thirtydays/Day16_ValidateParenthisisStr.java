package leetcode.thirtydays;

import java.util.Stack;

public class Day16_ValidateParenthisisStr {

	public static void main(String[] args) {
		System.out.println(checkValidString("()"));
		System.out.println(checkValidString("(*)"));
		System.out.println(checkValidString("(*))"));
		System.out.println(checkValidString(")("));
		System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
	}

	/*
	 * Any left parenthesis '(' must have a corresponding right parenthesis ')'. Any
	 * right parenthesis ')' must have a corresponding left parenthesis '('. Left
	 * parenthesis '(' must go before the corresponding right parenthesis ')'. '*'
	 * could be treated as a single right parenthesis ')' or a single left
	 * parenthesis '(' or an empty string.
	 */
	public static boolean checkValidString(String s) {
		if (s != null && (s.length() == 0 || s.trim().length() == 0)) {
			return true;
		}

		Stack<Integer> leftParanStack = new Stack<>();
		Stack<Integer> starStack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				leftParanStack.push(i);
			} else if (c == ')') {
				if (!leftParanStack.isEmpty()) {
					leftParanStack.pop();
				} else if (!starStack.isEmpty()) {
					starStack.pop();
				} else {
					return false;
				}
			} else if (c == '*') {
				starStack.push(i);
			}
		}

		while (!leftParanStack.isEmpty() && !starStack.isEmpty()) {
			Integer value = (int) starStack.pop();
			if (leftParanStack.peek() < value) {
				leftParanStack.pop();
			}
		}
		return leftParanStack.isEmpty();
	}
}
