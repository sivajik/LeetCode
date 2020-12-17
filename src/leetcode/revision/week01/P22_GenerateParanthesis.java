package leetcode.revision.week01;

import java.util.ArrayList;
import java.util.List;

public class P22_GenerateParanthesis {

	public static void main(String[] args) {
		int n = 3;
		for (String s : generateParenthesis(n)) {
			System.out.println(s);
		}
	}

	public static List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<String>();
		solve(n, n, res, "");
		return res;
	}

	private static void solve(int leftOverOpenBracketCount, int leftOverCloseBracketCount, List<String> res,
			String op) {
		// System.out.println(leftOverOpenBracketCount + " , " + leftOverCloseBracketCount);
		if (leftOverCloseBracketCount == leftOverOpenBracketCount && 0 == leftOverCloseBracketCount) {
			res.add(op);
			return;
		}

		if (leftOverOpenBracketCount == 0 && leftOverCloseBracketCount > 0) {
			solve(leftOverOpenBracketCount, leftOverCloseBracketCount - 1, res, op + ")");
		} else if (leftOverOpenBracketCount <= leftOverCloseBracketCount) {
			solve(leftOverOpenBracketCount - 1, leftOverCloseBracketCount, res, op + "(");
			solve(leftOverOpenBracketCount, leftOverCloseBracketCount - 1, res, op + ")");
		}
	}
	
	

}
