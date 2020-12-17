package leetcode.revision.week01;

public class P151_ReverseWordsInString {

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
		System.out.println(reverseWords("  hello world  "));
		System.out.println(reverseWords("a good   example"));
		System.out.println(reverseWords("  Bob    Loves  Alice   "));
		System.out.println(reverseWords("Alice does not even like bob"));
	}

	static public String reverseWords(String s) {
		s = s + " ";
		StringBuilder rslt = new StringBuilder();

		java.util.Stack<StringBuilder> stack = new java.util.Stack<>();

		StringBuilder temp = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (c != ' ') {
				temp.append(c);
			} else {
				if (temp.length() > 0) {
					stack.push(temp);
					temp = new StringBuilder();
				}
			}
		}
		while (!stack.isEmpty()) {
			rslt.append(stack.pop().toString());
			rslt.append(" ");
		}

		return rslt.toString().trim();
	}
}
