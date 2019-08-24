package leetcode.easy;

public class Prob917_ReverseOnlyLetters {

	public static void main(String[] args) {
		System.out.println(reverseOnlyLetters("ab-cd"));
		System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
		System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	}

	public static String reverseOnlyLetters(String S) {
		char[] input = S.toCharArray();
		char[] result = new char[S.length()];

		for (int i = 0; i < input.length; i++) {
			if (isSymbol(input[i])) {
				result[i] = input[i];
			}
		}
		for (int i = 0, reversePointer = input.length - 1; i < input.length; i++) {
			if (isAlpha(input[i])) {
				while (reversePointer > 0 && isSymbol(result[reversePointer])) {
					reversePointer = reversePointer - 1;
				}
				result[reversePointer] = input[i];
				reversePointer = reversePointer - 1;
			} else {
				continue;
			}
		}
		return new String(result);
	}

	public static boolean isAlpha(char x) {
		return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z');
	}

	public static boolean isSymbol(char x) {
		return x >= 33 && x <= 122 && !isAlpha(x);
	}
}
