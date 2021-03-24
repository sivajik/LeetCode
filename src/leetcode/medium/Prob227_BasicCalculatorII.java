package leetcode.medium;

import java.util.Stack;

public class Prob227_BasicCalculatorII {

	public static void main(String[] args) {
		System.out.println(calculate("22-3*5"));
		System.out.println(calculate("3/2"));
	}

	static public int calculate(String s) {
		if (s == null || s.isEmpty())
			return 0;

		int currNum = 0;
		char operation = '+';

		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				currNum = (currNum * 10) + (c - '0');
			}
			// with out 'i == s.length() - 1' this wont end.
			if (!Character.isWhitespace(c) && !Character.isDigit(c) || i == s.length() - 1) {
				if (operation == '+') {
					stk.push(currNum);
				} else if (operation == '-') {
					stk.push(-currNum);
				} else if (operation == '*') {
					stk.push(currNum * stk.pop());
				} else if (operation == '/') {
					stk.push(stk.pop() / currNum);
				}
				operation = c;
				currNum = 0;
			}

		}

		int result = 0;
		while (!stk.isEmpty()) {
			result += stk.pop();
		}
		return result;
	}
}
