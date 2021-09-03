package leetcode.easy;

public class Prob1021_RemoveOutermostParentheses {

	public static void main(String[] args) {
		System.out.println(removeOuterParentheses("(()())(())").equals("()()()"));
		System.out.println(removeOuterParentheses("(()())(())(()(()))").equals("()()()()(())"));
		System.out.println(removeOuterParentheses("()()").equals(""));
	}

	static public String removeOuterParentheses(String S) {
		char[] arr = S.toCharArray();
		StringBuilder res = new StringBuilder();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				if (count != 0) {
					res.append(arr[i]);
				}
				count++;
			} else if (arr[i] == ')') {
				count--;
				if (count != 0) {
					res.append(arr[i]);
				}
			}
		}
		return res.toString();
	}
}
