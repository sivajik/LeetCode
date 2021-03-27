package leetcode.medium;

import java.util.Stack;

public class Prob1209_RemoveAllAdjacentDuplicatesinStringII {

	public static void main(String[] args) {
		// System.out.println(removeDuplicates("abcd", 2));
		// System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
		// System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
		System.out.println(removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));

		// ybthyyyy
	}

	static public String removeDuplicates(String s, int k) {
		Stack<Character> stk = new Stack<>();
		Stack<Integer> count = new Stack<>();

		for (char c : s.toCharArray()) {
			if (!stk.isEmpty() && !count.isEmpty() && stk.peek() == c && count.peek() == k - 1) {
				while (!stk.isEmpty() && stk.peek() == c) {
					stk.pop();
				}
				count.pop();
			} else {
				int temp = 1;
				if (!count.isEmpty() && stk.peek() == c) {
					temp += count.pop();
				}
				stk.push(c);
				count.push(temp);
			}
		}

		StringBuilder sbr = new StringBuilder();
		while (!stk.isEmpty()) {
			sbr.append(stk.pop());
		}
		return sbr.reverse().toString();
	}
}
