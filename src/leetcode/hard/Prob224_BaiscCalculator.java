package leetcode.hard;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Prob224_BaiscCalculator {

	public static void main(String[] args) {
		System.out.println(calculate("8-3"));
		System.out.println(calculate("1-(+1+1)"));
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(calculate("2147483647"));

	}

	// READ BasicCal I, BasicCal II, BasicCalIII ::
	// https://leetcode.com/problems/basic-calculator/discuss/686489/Optimal-Generic-Solution-for-Basic-Calculator-I-II-III-Time-and-Space-O(N)

	static int i = 0;

	static public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int tmp = 0;
		int result = 0;
		int sign = +1;
		while (i < s.length()) {
			char c = s.charAt(i++);
			if (Character.isDigit(c)) {
				tmp = (tmp * 10) + (c - '0');
			} else if (c == '(') {
				tmp = calculate(s);
			} else if (c == ')') {
				break;
			} else if (c == '+' || c == '-') {
				result += sign * tmp;
				tmp = 0; // reset tmp;
				sign = (c == '+') ? +1 : -1;
			}
		}
		result += sign * tmp;
		return result;
	}

	private static Queue<String> infixToPostfix(String infix, Stack<Character> stack) {
		Queue<String> postfix = new LinkedList<>();
		for (int i = 0; i < infix.length(); i++) {
			StringBuilder num = new StringBuilder();
			while (i < infix.length() && Character.isDigit(infix.charAt(i))) {
				num.append(infix.charAt(i++));
			}
			if (num.length() != 0) {
				postfix.offer(num.toString());
			}
			if (i == infix.length())
				break;

			char currChar = infix.charAt(i);
			if (currChar == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					postfix.offer(String.valueOf(stack.pop()));
				if (!stack.isEmpty())
					stack.pop();
			} else if (currChar == '+' || currChar == '-') {
				if (!stack.isEmpty() && (stack.peek() == '+' || stack.peek() == '-')) {
					postfix.offer(String.valueOf(stack.pop()));
				}
				stack.push(currChar);
			} else if (!Character.isSpaceChar(currChar)) {
				stack.push(currChar);
			}
		}

		while (!stack.isEmpty())
			postfix.offer(String.valueOf(stack.pop()));
		return postfix;
	}

}