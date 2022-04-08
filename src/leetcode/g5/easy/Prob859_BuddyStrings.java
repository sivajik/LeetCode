package leetcode.g5.easy;

public class Prob859_BuddyStrings {

	public static void main(String[] args) {
		System.out.println(buddyStrings("ab", "ba"));
		System.out.println(buddyStrings("abcd", "cbad"));
		System.out.println(buddyStrings("ab", "ab"));
		System.out.println(buddyStrings("aa", "aa"));
	}

	static public boolean buddyStrings(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		} else {
			if (s.equals(goal)) {
				java.util.Set<Character> set = new java.util.HashSet<>();
				for (int i = 0; i < s.length(); i++) {
					if (set.contains(s.charAt(i)))
						return true;
					else
						set.add(s.charAt(i));
				}
				return false;
			} else {
				int mismatches = 0;
				char[] sC = new char[2];
				char[] gC = new char[2];

				for (int i = 0; i < s.length(); i++) {
					char a = s.charAt(i);
					char b = goal.charAt(i);

					if (a == b) {
						continue;
					} else {
						if (mismatches >= 2) {
							return false;
						} else {
							sC[mismatches] = a;
							gC[mismatches] = b;
							mismatches++;
						}
					}
				}
				return mismatches == 2 && sC[0] == gC[1] && sC[1] == gC[0];
			}
		}
	}
}
