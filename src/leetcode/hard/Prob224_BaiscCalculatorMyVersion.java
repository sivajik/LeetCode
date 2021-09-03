package leetcode.hard;

import java.util.Stack;

public class Prob224_BaiscCalculatorMyVersion {

	public static void main(String[] args) {
		/*System.out.println(calculate("1 + 1"));
		System.out.println(calculate(" 2-1 + 2 "));
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(calculate("2147483647"));
		*/
		System.out.println("(1+(4+5+2)-3)+(6+8)" + " -> " + infixToPostfix("(1+(4+5+2)-3)+(6+8)"));
	}

	static public int calculate(String s) {
		String updated = infixToPostfix(s);
		System.out.println("Postfix: " + updated);
		return evalPostfix(updated);
	}

	private static String infixToPostfix(String s) {
		String op = "";
		Stack<Character> stk = new Stack<>();
		for (char c : s.toCharArray()) {
			if (Character.isLetterOrDigit(c)) {
				op += c;
			} else if (c == ' ') {
				continue;
			} else if (c == '(') {
				stk.push('(');
			} else if (c == ')') {
				while (!stk.isEmpty() && stk.peek() != '(') {
					op += stk.pop();
				}
			} else {
				while (!stk.isEmpty() && prec(c) <= prec(stk.peek())) {
					op += stk.pop();
				}
				stk.push(c);
			}
		}
		while (!stk.isEmpty()) {
			op += stk.pop();
		}
		return op;
	}

	static int prec(char c) {
		switch (c) {
		case '+':
			return 1;
		case '-':
			return 2;
		}
		return -1;
	}

	private static int evalPostfix(String updated) {
		Stack<Integer> stk = new Stack<>();
		for (char c : updated.toCharArray()) {
			if (c >= '0' && c <= '9') {
				stk.push(c - '0');
			} else if (c == '+') {
				Integer a = stk.pop();
				Integer b = stk.pop();
				Integer res = a + b;
				stk.push(res);
			} else if (c == '-') {
				Integer a = stk.pop();
				Integer b = stk.pop();
				Integer res = b - a;
				stk.push(res);
			}
		}
		if (stk.size() == 1) {
			return stk.pop();
		} else {
			StringBuilder s = new StringBuilder();
			while (!stk.isEmpty()) {
				s.append(stk.pop());
			}
			return Integer.parseInt(s.reverse().toString());
		}
	}
}
