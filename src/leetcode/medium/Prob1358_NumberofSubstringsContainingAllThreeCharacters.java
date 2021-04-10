package leetcode.medium;

public class Prob1358_NumberofSubstringsContainingAllThreeCharacters {

	public static void main(String[] args) {
		System.out.println(numberOfSubstrings("abcabc"));

	}

	static public int numberOfSubstrings(String s) {
		int ai = -1, bi = -1, ci = -1;
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				ai = i;
				if (bi != -1 && ci != -1) {
					ans = ans + Math.min(bi, ci) + 1;
				}
			} else if (s.charAt(i) == 'b') {
				bi = i;
				if (ai != -1 && ci != -1) {
					ans = ans + Math.min(ai, ci) + 1;
				}
			} else if (s.charAt(i) == 'c') {
				ci = i;
				if (bi != -1 && ai != -1) {
					ans = ans + Math.min(bi, ai) + 1;
				}
			}
		}
		return ans;
	}
}
