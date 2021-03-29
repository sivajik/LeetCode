package leetcode.medium;

public class Prob647_PalindromicSubstrings {

	public static void main(String[] args) {
		System.out.println(countSubstrings("aaa"));
		System.out.println(countSubstrings("abc"));
	}

	static public int countSubstrings(String s) {
		int c = 0;
		for (int i = 0; i < s.length(); i++) {
			c += expand(s, i, i);
			c += expand(s, i, i + 1);
		}
		return c;
	}

	private static int expand(String s, int i, int j) {
		int ans = 0;
		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) != s.charAt(j)) {
				break;
			}
			i--;
			j++;
			ans++;
		}
		return ans;
	}

}
