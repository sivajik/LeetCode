package leetcode.easy;

public class Prob387_NonRepeatedChas {

	public static void main(String[] args) {
		// System.out.println(firstUniqChar("leetcode"));
		// System.out.println(firstUniqChar("loveleetcode"));
		System.out.println(firstUniqChar("cc"));
	}

	public static int firstUniqChar(String s) {
		int[] arr = new int[27]; // leave index 0 for convenience.
		for (int i = 0; i < s.length(); i++) {
			int character = s.charAt(i) - 'a';
			arr[character] = arr[character] + 1;
		}
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 'a';
			if (arr[c] == 1) {
				return i;
			}
		}

		return -1;
	}
}
