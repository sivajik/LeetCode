package leetcode.easy;

import java.util.Stack;

public class Prob716_MaxStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class MaxStack {
		Stack<Integer> stack;
		Stack<Integer> maxStack;

		public MaxStack() {
			stack = new Stack<>();
			maxStack = new Stack<>();
		}

		public void push(int x) {
			stack.push(x);

			if (maxStack.isEmpty()) {
				maxStack.push(x);
			} else {
				int currMax = maxStack.peek();
				if (x > currMax) {
					maxStack.push(x);
				} else {
					maxStack.push(currMax);
				}
			}
		}

		public int pop() {
			maxStack.pop();
			return stack.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int peekMax() {
			return maxStack.peek();
		}

		public int popMax() {
			int currMax = maxStack.peek();

			Stack<Integer> temp = new Stack<>();
			while (top() != currMax) {
				temp.push(pop());
			}

			// without this you are done bhai...
			pop();
			
			while (!temp.isEmpty()) {
				push(temp.pop());
			}

			return currMax;
		}
	}
}
