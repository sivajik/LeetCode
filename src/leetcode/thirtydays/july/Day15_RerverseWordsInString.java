package leetcode.thirtydays.july;

public class Day15_RerverseWordsInString {

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));

	}

	static public String reverseWords(String s) {
		String trimmed = s.trim();
		String[] tokens = trimmed.split(" ");

		StringBuilder sbr = new StringBuilder();
		for (int i = tokens.length - 1; i >= 0; i--) {
			if (tokens[i].trim().length() > 0) {
				sbr.append(tokens[i].trim());
				sbr.append(" ");
			}
		}
		return sbr.toString().trim();

	}
}
