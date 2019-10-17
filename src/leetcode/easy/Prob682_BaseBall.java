package leetcode.easy;

import java.util.Stack;

public class Prob682_BaseBall {

	public static void main(String[] args) {
		System.out.println(calPoints(new String[] { "5", "2", "C", "D", "+" }));
		System.out.println(calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));
	}

	// assuming valid data is passed ???
	public static int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<Integer>();

		int score = 0;

		for (String op : ops) {
			if (op.equals("C")) {
				int temp1 = stack.peek();
				score += (-1 * temp1);
				stack.pop();
			} else if (op.equals("D")) {
				int temp1 = stack.peek();
				stack.push(temp1 + temp1);
				score = score + (temp1 + temp1);
			} else if (op.equals("+")) {
				int temp1 = stack.pop();
				int temp2 = stack.pop();
				score += temp1 + temp2;
				stack.push(temp2);
				stack.push(temp1);
				stack.push(temp1 + temp2);
			} else {
				int temp = Integer.parseInt(op);
				stack.push(temp);
				score += temp;
			}
		}

		return score;
	}
}
