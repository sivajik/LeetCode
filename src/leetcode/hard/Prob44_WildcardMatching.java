package leetcode.hard;

public class Prob44_WildcardMatching {

	public static void main(String[] args) {
		System.out.println(isMatch("abbbd", "a*d"));
	}

	static public boolean isMatch(String s, String p) {

		int sLen = s.length();
		int pLen = p.length();

		int sIndex = 0, pIndex = 0;
		int starIndex = -1;
		int sTmpIdx = -1;
		while (sIndex < sLen) {
			if (pIndex < pLen && (p.charAt(pIndex) == '?' || p.charAt(pIndex) == s.charAt(sIndex))) {
				pIndex++;
				sIndex++;
			} else if (pIndex < pLen && p.charAt(pIndex) == '*') {
				// mean many or more
				starIndex = pIndex;
				sTmpIdx = sIndex;
				pIndex++;
			} else if (starIndex == -1) {
				return false;
			} else {
				// Backtrack: check the situation
				// when '*' matches one more character
				pIndex = starIndex + 1;
				sIndex = sTmpIdx + 1;
				sTmpIdx = sIndex;
			}
		}

		for (int i = pIndex; i < pLen; i++) {
			if (p.charAt(i) != '*') {
				return false;
			}
		}
		return true;

	}

}
