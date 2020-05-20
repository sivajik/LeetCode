package leetcode.easy;

public class Prob1370_IncDecString {

	public static void main(String[] args) {
		System.out.println(sortString("aaaabbbbcccc"));
		System.out.println(sortString("rat"));
		System.out.println(sortString("leetcode"));
		System.out.println(sortString("ggggggg"));
		System.out.println(sortString("spo"));
		System.out.println(sortString("a"));
	}

	public static String sortString(String s) {
		StringBuffer sb = new StringBuffer();
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}

		int c = 0;
		while (c < s.length()) {
			// pick smallest char.
			for (int i = 0; i < 26; i++) {
				if (freq[i] != 0) {
					char smallestChar = (char) (i + 'a');
					sb.append(smallestChar);
					freq[i]--;
					c++;
				}
			}

			// pick largest char.
			for (int i = 25; i >= 0; i--) {
				if (freq[i] != 0) {
					char largestChar = (char) (i + 'a');
					sb.append(largestChar);
					freq[i]--;
					c++;
				}
			}
		}
		return sb.toString();
	}
}
