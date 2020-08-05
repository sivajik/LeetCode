package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob22_GenerateParentheses2 {

	public static void main(String[] args) {
		for (String s : generateParenthesis(3)) {
			System.out.println(s);
		}
	}

	static public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		if (n <= 0) {
			return result;
		}
		solver(result, "", 0,0,n);
		return result;
	}

	private static void solver(List<String> result, String curr, int open, int close, int n) {
		if (curr.length() == 2 * n) {
			result.add(curr);
			return;
		}
		
		if (open < n) {
			solver(result, curr + "(", open+1, close, n);
		}
		if (close < open) {
			solver(result, curr + ")", open, close+1, n);
		}
	}

}
