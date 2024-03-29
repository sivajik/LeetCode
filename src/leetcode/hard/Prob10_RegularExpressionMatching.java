package leetcode.hard;

public class Prob10_RegularExpressionMatching {

	public static void main(String[] args) {
		//System.out.println(isMatch("aa", "a") == false);
		//System.out.println(isMatch("aa", "a*") == true);
		//System.out.println(isMatch("ab", ".*") == true);
		System.out.println(isMatch("aab", "c*a*b") == true);
		System.out.println(isMatch("mississippi", "mis*is*p*.") == false);
		System.out.println(isMatch("ab", ".*c") == false);
	}

	static enum Result {
		TRUE, FALSE;
	}

	static public boolean isMatch(String s, String p) {
		// the basic idea we must follow are:
		// * -> matches 0 or more occurance of the sequece before *
		// . -> macthes any single character

		// here we are doing the bottom up dp approach
		// the way we fill the table is based on the follwoing ides
		// T[i][j] = T[i-1][j-1] if text[i] = pattern[j] || pattern[j] = '.'
		// if pattern[j] = '*', we have two possibilites, either 0 occurance or more
		// occurance
		// for 0 occurance T[i][j] = T[i][j-2]
		// for more occurance T[i][j] = T[i-1][j] iff text[i] = patern[j-1] ||
		// pattern[j-1] = '.'

		// for all other cased T[i][j] = false

		int length1 = s.length();
		int length2 = p.length();

		boolean[][] dp = new boolean[length1 + 1][length2 + 1];
		dp[0][0] = true;
		boolean valid = false;
		for (int i = 2; i <= length2; i += 2) {
			if (p.charAt(i - 1) == '*') {
				dp[0][i] = true;
				valid = true;
			} else {
				valid = false;
			}
			if (!valid)
				break;
		}
		
		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				dp[i][j] = false;
				// if text[i] = pattern[i] or = '.'
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
					dp[i][j] = dp[i - 1][j - 1];
				// if pattern[j] = '*'
				else if (p.charAt(j - 1) == '*') {
					// 2 possibilities
					// 1 or more occurance
					if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
						dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
					// 0 occurance
					else
						dp[i][j] = dp[i][j - 2];
				}
			}
		}
		return dp[length1][length2];
	}

	static public boolean isMatch1(String s, String p) {
		if (p == null || p.isEmpty()) {
			return s.isEmpty();
		}

		boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

		if (p.length() >= 2 && p.charAt(1) == '*') {
			// a*
			return isMatch1(s, p.substring(2)) || (firstMatch && isMatch1(s.substring(1), p));
		} else {
			return firstMatch && isMatch1(s.substring(1), p.substring(1));
		}
	}
}
