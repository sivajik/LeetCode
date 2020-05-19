package leetcode.medium;

public class Prob567_PermutationInString {

	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion("ab", "eidboaoo"));
		System.out.println(checkInclusion("oo", "eidboaoo"));		
	}

	public static boolean checkInclusion(String s1, String s2) {
		int[] s1Freq = getCharFre(s1.toCharArray());

		for (int i = 0; i <= s2.length() - s1.length(); i++) {
			String slidingStr = s2.substring(i, i + s1.length());
			int[] slidingFreq = getCharFre(slidingStr.toCharArray());
			if (java.util.Arrays.equals(slidingFreq, s1Freq)) {
				return true;
			}
		}
		return false;
	}

	private static int[] getCharFre(char[] sOne) {
		int[] res = new int[26];
		for (int i = 0; i < sOne.length; i++) {
			res[sOne[i] - 'a']++;
		}
		return res;
	}
}
