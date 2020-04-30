package leetcode.thirtydays.april;

import java.util.Stack;

public class Day09_BackSpaceStringCompare {

	public static void main(String[] args) {
		System.out.println(backspaceCompare("abcd####", "efgh###"));
		System.out.println(backspaceCompare("ab#c", "ad#c")); // true
		System.out.println(backspaceCompare("ab##", "c#d#")); // true
		System.out.println(backspaceCompare("a##c", "#a#c")); // true
		System.out.println(backspaceCompare("a#c", "b")); // false
	}

	public static boolean backspaceCompare(String S, String T) {
		return getString(S).equals(getString(T));
	}

	public static String getString(String S) {
		Stack<Character> stack = new Stack<Character>();

		for (char c : S.toCharArray()) {
			if (c == '#') {
				if (stack.isEmpty()) {
					continue;
				}

				if (!stack.isEmpty() && stack.peek() != '#') {
					stack.pop();
				}
			} else {
				stack.push(c);
			}
		}
		return stack.toString();
	}
}
