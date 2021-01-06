package leetcode.revision.week04;

public class P150_EvaluateRPN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public int evalRPN(String[] tokens) {

		java.util.Stack<Integer> stack = new java.util.Stack<>();
		for (String str : tokens) {
			if (str.equals("+")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a + b);
			} else if (str.equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b - a);
			} else if (str.equals("*")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a * b);
			} else if (str.equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b / a);
			} else {
				stack.push(Integer.parseInt(str));
			}
		}
		return stack.isEmpty() ? 0 : stack.pop();

	}
}
