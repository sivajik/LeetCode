package leetcode.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * sooper dooper logic for any k distinct longest substring 
 */
public class Prob340_LongestSubstringwithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2));
	}

	static public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if (s == null || s.length() == 0 || k == 0) {
			return 0;
		}

		int left = 0;
		int right = 0;
		int maxLen = 1;
		int n = s.length();
		Map<Character, Integer> rightmostPositionMap = new HashMap<>();

		while (right < n) {
			rightmostPositionMap.put(s.charAt(right), right++);

			if (rightmostPositionMap.size() == k + 1) {
				int lowestIndex = Collections.min(rightmostPositionMap.values());
				rightmostPositionMap.remove(s.charAt(lowestIndex));
				left = lowestIndex + 1;
			}
			maxLen = Math.max(maxLen, right - left);
		}
		return maxLen;
	}
}
