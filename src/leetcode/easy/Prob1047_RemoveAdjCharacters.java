package leetcode.easy;

import java.util.Stack;

public class Prob1047_RemoveAdjCharacters {

	public static void main(String[] args) {
		System.out.println(removeDuplicates("aaaa"));
		System.out.println(removeDuplicates("abbaca"));
	}

	public static String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : S.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		StringBuilder sbr = new StringBuilder();
		while (!stack.isEmpty()) {
			sbr.append(stack.pop());
		}		
		return sbr.reverse().toString();
	}
}