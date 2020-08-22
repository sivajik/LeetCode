package leetcode.revision.medium;

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

	private static void solve(int roc, int rcc, List<String> res, String op) {
		if (roc == rcc && roc == 0) {
			res.add(op);
			return;
		}

		if (roc == 0 && rcc > 0) {
			solve(roc, rcc - 1, res, op + ")");
		} else if (roc <= rcc) {
			solve(roc - 1, rcc, res, op + "(");
			solve(roc, rcc - 1, res, op + ")");
		}
	}
}
