package leetcode.easy;

public class Prob824_GoatLatinCrapProblem {

	public static void main(String[] args) {
		System.out.println(toGoatLatin("I speak Goat Latin"));
		System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
	}

	public static String toGoatLatin(String S) {
		String[] tokens = S.split(" ");
		StringBuilder finalAns = new StringBuilder();
		for (int i = 0; i < tokens.length; i++) {
			String str = tokens[i];
			StringBuffer sbfr = new StringBuffer();
			char firstChar = str.toLowerCase().charAt(0);

			if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u') {
				sbfr.append(str);
				sbfr.append("ma");
			} else {
				char c = str.charAt(0);
				str = str.substring(1);
				sbfr.append(str);
				sbfr.append(c);
				sbfr.append("ma");
			}

			for (int j = 0; j < (i + 1); j++) {
				sbfr.append("a");
			}

			finalAns.append(sbfr);
			if (i != tokens.length - 1) {
				finalAns.append(" ");
			}
		}
		return finalAns.toString();
	}
}
