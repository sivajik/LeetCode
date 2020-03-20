package leetcode.easy;

import java.util.Stack;

public class Prob1221_SplitBalancedStrings {

	public static void main(String[] args) {
		System.out.println(balancedStringSplit("RLRRLLRLRL"));
		System.out.println(balancedStringSplit("RLLLLRRRLR"));
		System.out.println(balancedStringSplit("LLLLRRRR"));
		System.out.println(balancedStringSplit("RLRRRLLRLL"));
	}

	public static int balancedStringSplit(String s) {
		int count = 0;
		Stack<Character> stack = new Stack<Character>();

		for (char c : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(c);
			} else {
				if (stack.peek() != c) {
					stack.pop();
				} else {
					stack.push(c);
				}
			}

			if (stack.isEmpty()) {
				count++;
			}
		}

		return count;
	}
}
