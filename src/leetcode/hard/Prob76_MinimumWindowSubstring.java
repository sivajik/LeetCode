package leetcode.hard;

public class Prob76_MinimumWindowSubstring {

	public static void main(String[] args) {
		System.out.println(minWindow("ADOBECODEBANC", "ABC"));

	}
	
	// https://leetcode.com/problems/minimum-window-substring/discuss/1101326/succinct-code-so-that-you-can-code-it-in-minutes-(for-similar-problems-as-well).
	// Add all the characters of the to be found string in a map.
	// loop through the main string and decrement the map at respective index.
	// maintain a count of the to be found string also once it reaches zero start a while loop
	// keep going until it is zero.
	// calculate the length, change min if it is smaller, and increment the firstpointer, the value at that index and the counter.
	
	static public String minWindow(String s, String t) {
		int[] indexes = new int[128];
		for (char c : t.toCharArray()) {
			indexes[c]++;
		}

		int firstPointer = 0, secondPointer = 0, startIndex = 0;
		int counter = t.length();
		int min = Integer.MAX_VALUE;

		while (secondPointer < s.length()) {
			if (--indexes[s.charAt(secondPointer++)] >= 0) {
				counter--;
			}

			// all characters in t are processed.
			while (counter == 0) {
				if (min > secondPointer - firstPointer) {
					min = secondPointer - firstPointer;
					startIndex = firstPointer;
				}

				if (++indexes[s.charAt(firstPointer++)] > 0) {
					counter++;
				}
			}
		}

		return min == Integer.MAX_VALUE ? "" : s.substring(startIndex, min + startIndex);
	}
}
