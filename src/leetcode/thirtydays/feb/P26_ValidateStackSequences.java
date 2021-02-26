package leetcode.thirtydays.feb;

import java.util.Stack;

public class P26_ValidateStackSequences {

	public static void main(String[] args) {
		System.out.println(validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 }));
	}

	static public boolean validateStackSequences(int[] pushed, int[] popped) {
		Stack<Integer> s = new Stack<>();
		int j = 0;

		for (int i = 0; i < pushed.length; i++) {
			s.push(pushed[i]);
			while (s.size() > 0 && s.peek() == popped[j]) {
				s.pop();
				j++;
			}
		}
		return j == pushed.length;
	}
}
