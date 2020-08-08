package leetcode.medium;

public class Prob1381_StackWithIncrementOption {
	public static void main(String[] args) {
		CustomStack c = new CustomStack(3);
		c.push(1);
		c.push(2);
		c.pop();
		c.push(2);
		c.push(3);
		c.push(4);
		c.increment(5, 100);
		c.increment(2, 100);
		System.out.println(c.pop());
		System.out.println(c.pop());
		System.out.println(c.pop());
		System.out.println(c.pop());
	}

}

class CustomStack {
	java.util.Stack<Integer> stack;
	int maxSize;

	public CustomStack(int maxSize) {
		this.stack = new java.util.Stack<>();
		this.maxSize = maxSize;
	}

	public void push(int x) {
		if (stack.size() < maxSize) {
			stack.push(x);
		}
	}

	public int pop() {
		if (!stack.isEmpty()) {
			return stack.pop();
		}
		return -1;
	}

	public void increment(int k, int val) {
		if (stack.size() > k) { // 12 3
			for (int i = 0; i < k; i++) {
				stack.set(i, val + stack.get(i));
			}
		} else { // 5, top 8
			for (int i = 0; i < stack.size(); i++) {
				stack.set(i, val + stack.get(i));
			}
		}
	}
	
	public void increment1(int k, int val) {
		java.util.Stack<Integer> tempStack = new java.util.Stack<Integer>();
		int elemToPop = stack.size();
		if (stack.size() > k) { // 12 3
			elemToPop = stack.size() - k; // 9

			for (int i = 0; i < elemToPop; i++) {
				tempStack.push(stack.pop());
			}
			while (!stack.isEmpty()) {
				tempStack.push(stack.pop() + val);
			}
		} else { // 5, top 8
			while (!stack.isEmpty()) {
				tempStack.push(stack.pop() + val);
			}
		}

		while (!tempStack.isEmpty()) {
			stack.push(tempStack.pop());
		}
	}
}