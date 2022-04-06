package leetcode.g5.easy;

import java.util.Arrays;

public class Prob942_DIStringMatch {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(diStringMatch("IDID")));
		System.out.println(Arrays.toString(diStringMatch("III")));
		System.out.println(Arrays.toString(diStringMatch("DDI")));
	}

	static public int[] diStringMatch(String s) {
		int low = 0;
		int high = s.length();
		int[] res = new int[s.length() + 1];
		int counter = 0;
		for (char c : s.toCharArray()) {
			if (c == 'I') {
				res[counter++] = low++;
			} else {
				res[counter++] = high--;
			}
		}
		res[counter] = low;
		return res;
	}
}
