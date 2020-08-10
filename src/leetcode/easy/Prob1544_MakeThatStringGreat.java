package leetcode.easy;

public class Prob1544_MakeThatStringGreat {

	public static void main(String[] args) {
		System.out.println(makeGood("leEeetcode"));
		System.out.println(makeGood("abBAcC"));
		System.out.println(makeGood("s"));
	}

	static public String makeGood(String s) {
		int diff = Math.abs('a' - 'A');

		java.util.Stack<Character> stack = new java.util.Stack<>();
		for (char c : s.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(c);
				continue;
			}
			char topChar = stack.peek();
			if (diff == Math.abs(topChar - c)) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		StringBuilder sbldr = new StringBuilder();
		while (!stack.isEmpty()) {
			sbldr.append(stack.pop());
		}
		return sbldr.reverse().toString();
	}
}
