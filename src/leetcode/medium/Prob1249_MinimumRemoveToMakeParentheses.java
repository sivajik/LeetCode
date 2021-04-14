package leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prob1249_MinimumRemoveToMakeParentheses {

	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
		System.out.println(minRemoveToMakeValid("a)b(c)d"));
		System.out.println(minRemoveToMakeValid("))(("));
		System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
	}

	static public String minRemoveToMakeValid(String s) {
		List<Integer> listOfIndices2Remove = new ArrayList<>();

		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.push(i);
			} else if (s.charAt(i) == ')') {
				if (st.isEmpty()) {
					listOfIndices2Remove.add(i);
				} else {
					st.pop();
				}
			}
		}

		while (!st.isEmpty()) {
			listOfIndices2Remove.add(st.pop());
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (!listOfIndices2Remove.contains(i)) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
}
