package leetcode.medium;

public class Prob394_DecodeString {

	public static void main(String[] args) {
		System.out.println(decodeString("12[b]"));
	}

	static public String decodeString(String s) {
		char[] arr = s.toCharArray();

		java.util.Stack<String> stack = new java.util.Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ']') {
				StringBuffer sbfr = new StringBuffer();
				while (!stack.peek().equalsIgnoreCase("[")) {
					sbfr.append(stack.pop());
				}
				stack.pop();

				String freq = stack.pop();
				int freN = Integer.parseInt(freq);
				StringBuffer temp = new StringBuffer();
				for (int f = 0; f < freN; f++) {
					temp = temp.append(sbfr);
				}
				stack.push(temp.toString());
			} else if (arr[i] == '[') {
				// 1 0 0 => 0 0 1
				StringBuffer sbfr = new StringBuffer();
				while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
					sbfr.append(stack.pop());
				}
				sbfr.reverse();
				stack.push(sbfr.toString());
				stack.push("[");
			} else {
				stack.push("" + arr[i]);
			}
		}

		StringBuffer sbfr = new StringBuffer();
		while (!stack.isEmpty()) {
			sbfr.append(stack.pop());
		}
		return sbfr.reverse().toString();

	}
}
