package leetcode.thirtydays;

import java.util.Stack;

public class Day10_MinStack {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // --> Returns -3.
		minStack.pop();
		System.out.println(minStack.top()); // --> Returns 0.
		System.out.println(minStack.getMin()); // --> Returns -2.

	}
}

class MinStack {
	private Stack<ElemWithMinElem> myStack;

	public MinStack() {
		this.myStack = new Stack<ElemWithMinElem>();
	}

	public void push(int x) {
		if (myStack.isEmpty()) {
			myStack.push(new ElemWithMinElem(x, x));
		} else {
			myStack.push(new ElemWithMinElem(x, Math.min(myStack.peek().getSoFarMinElem(), x)));
		}
	}

	public void pop() {
		if (!myStack.isEmpty()) {
			myStack.pop();
		}
	}

	public int top() {
		if (myStack.isEmpty()) {
			throw new RuntimeException("top :: empty stack!!!");
		}
		return myStack.peek().getElem();
	}

	public int getMin() {
		if (myStack.isEmpty()) {
			throw new RuntimeException("getMin :: empty stack!!!");
		}
		return myStack.peek().getSoFarMinElem();
	}

	static class ElemWithMinElem {
		int elem;
		int soFarMinElem;

		public ElemWithMinElem(int elem, int soFarMinElem) {
			super();
			this.elem = elem;
			this.soFarMinElem = soFarMinElem;
		}

		public void setElem(int elem) {
			this.elem = elem;
		}

		public void setSoFarMinElem(int soFarMinElem) {
			this.soFarMinElem = soFarMinElem;
		}

		public int getElem() {
			return elem;
		}

		public int getSoFarMinElem() {
			return soFarMinElem;
		}

	}
}