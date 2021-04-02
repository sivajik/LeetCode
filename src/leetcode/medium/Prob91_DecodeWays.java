package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class Prob91_DecodeWays {

	public static void main(String[] args) {
		System.out.println(numDecodings("226"));

	}

	static public int numDecodings(String s) {
		return helper(s, 0);
	}

	static Map<Integer, Integer> memo = new HashMap<>();

	private static int helper(String s, int index) {
		if (memo.containsKey(index)) {
			return memo.get(index);
		}
		//next 3 ifs ordering is important...
        if (index == s.length() ) {
			return 1;
		}
        
        if (s.charAt(index) == '0') {
			return 0;
		}
        
		if (index == s.length() - 1) {
			return 1;
		}

		int ans = helper(s, index + 1);

		String get2Lts = s.substring(index, index + 2);
		if (Integer.parseInt(get2Lts) <= 26) {
			ans += helper(s, index + 2);
		}

		memo.put(index, ans);
		return ans;
	}
}
