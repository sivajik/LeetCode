package leetcode.revision.week03;

import java.util.Stack;

public class P678_ValidParenthesisString {

	public static void main(String[] args) {
		System.out.println(checkValidString("()"));
		System.out.println(checkValidString("(*)"));
		System.out.println(checkValidString("(*))"));
		System.out.println(checkValidString(")("));
		System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));

	}

	static public boolean checkValidString(String s) {
		if (s != null && (s.trim().length() == 0)) {
			return true;
		}

		Stack<Integer> leftP = new Stack<>();
		Stack<Integer> starS = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				leftP.push(i);
			} else if (c == ')') {
				if (!leftP.isEmpty()) {
					leftP.pop();
				} else if (!starS.isEmpty()) {
					starS.pop();
				} else {
					return false;
				}
			} else if (c == '*') {
				starS.push(i);
			}
		}

		while (!leftP.isEmpty() && !starS.isEmpty()) {
			int indexOfStar = starS.pop();
			if (leftP.peek() < indexOfStar) {
				leftP.pop();
			}
		}

		return leftP.isEmpty();
	}
}
