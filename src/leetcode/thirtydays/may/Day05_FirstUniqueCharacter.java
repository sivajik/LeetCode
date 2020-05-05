package leetcode.thirtydays.may;

public class Day05_FirstUniqueCharacter {

	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
	}

	public static int firstUniqChar(String s) {

		int[] arr = new int[27];
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 'a';

			arr[c] = arr[c] + 1;
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
