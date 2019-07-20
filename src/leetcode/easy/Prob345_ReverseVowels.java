package leetcode.easy;

public class Prob345_ReverseVowels {

	public static void main(String[] args) {
		System.out.println(reverseVowels("hello"));
		System.out.println(reverseVowels("leetcode"));
		System.out.println(reverseVowels("aA"));
	}

	public static String reverseVowels(String s) {
		char[] chars = s.toCharArray();
		int lIndex = 0;
		int rIndex = s.length() - 1;
		while (lIndex < rIndex) {
			while (!isVowel(chars[lIndex]) && lIndex < rIndex) {
				lIndex++;
			}
			while (!isVowel(chars[rIndex]) && lIndex < rIndex) {
				rIndex--;
			}

			char c = chars[lIndex];
			chars[lIndex] = chars[rIndex];
			chars[rIndex] = c;
			lIndex++;
			rIndex--;
		}

		return new String(chars);
	}

	public static boolean isVowel(char c) {
		return Character.toLowerCase(c) == 'a' || Character.toLowerCase(c) == 'e' || Character.toLowerCase(c) == 'i'
				|| Character.toLowerCase(c) == 'o' || Character.toLowerCase(c) == 'u';
	}
}
