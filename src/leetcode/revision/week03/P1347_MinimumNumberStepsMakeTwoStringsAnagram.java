package leetcode.revision.week03;

public class P1347_MinimumNumberStepsMakeTwoStringsAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static public int minSteps(String s, String t) {
		int[] freq = new int[26];
		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}

		for (char c : t.toCharArray()) {
			if (freq[c - 'a'] > 0) {
				freq[c - 'a']--;
			}
		}

		int sum = 0;
		for (int f : freq) {
			sum += f;
		}
		return sum;
	}
}
