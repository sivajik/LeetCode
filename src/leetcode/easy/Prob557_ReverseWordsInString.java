package leetcode.easy;

public class Prob557_ReverseWordsInString {

	public static void main(String[] args) {
		System.out.println("output: " + reverseWords("Let's take LeetCode contest"));
		System.out.println("output: " + reverseWords("apple"));
		System.out.println("output: " + reverseWords(""));

	}

	public static String reverseWords(String s) {
		char[] result = new char[s.length()];
		int counter = 0;

		String[] words = s.split(" ");
		for (String word : words) {
			char[] chars = word.toCharArray();
			for (int i = chars.length - 1; i >= 0; i--) {
				result[counter++] = chars[i];
			}
			if (counter != s.length())
				result[counter++] = ' ';
		}
		return new String(result);
	}
}
