package leetcode.medium;

public class Prob1347_MiniNumStepsMakeAnagram {

	public static void main(String[] args) {
		System.out.println(minSteps("bab", "aba") == 1);
	}

	static public int minSteps(String s, String t) {
		int[] freq = new int[26];

		for (char c : s.toCharArray()) {
			freq[c - 'a']++;
		}
		for (char c : t.toCharArray()) {
			if (freq[c - 'a'] > 0) 
				freq[c - 'a']--;
		}
		int sum = 0;
		for (int elem : freq) {
			sum += elem;
		}
		return sum;
	}
}
