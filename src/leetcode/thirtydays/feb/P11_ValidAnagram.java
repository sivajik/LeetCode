package leetcode.thirtydays.feb;

public class P11_ValidAnagram {

	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rat", "cat"));
	}

	public static boolean isAnagram(String s, String t) {
		int[] sArray = new int[26];
		for (char c : s.toCharArray()) {
			sArray[c - 'a']++;
		}

		int[] tArray = new int[26];
		for (char c : t.toCharArray()) {
			tArray[c - 'a']++;
		}
		return java.util.Arrays.equals(sArray, tArray);
	}
}
