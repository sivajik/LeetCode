package leetcode.thirtydays;

import java.util.Stack;

public class Day09_BackSpaceStringCompare {

	public static void main(String[] args) {
		System.out.println(backspaceCompare("abcd####", "efgh###"));

	}
    public  static boolean backspaceCompare(String S, String T) {
		return getString(S).equals(getString(T));
	}

	public static  String getString(String S) {
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
