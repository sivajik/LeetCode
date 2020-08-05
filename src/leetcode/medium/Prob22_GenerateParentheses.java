package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob22_GenerateParentheses {

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
		solver(/* startIndex= */0, new char[2 * n], result);
		return result;
	}

	static private void solver(int currIndex, char[] chars, List<String> result) {
		if (currIndex == chars.length) {
			if (isValid(chars)) {
				result.add(new String(chars));
			}
			return;
		}
		chars[currIndex] = '(';
		solver(currIndex + 1, chars, result);
		chars[currIndex] = ')';
		solver(currIndex + 1, chars, result);
	}

	static private boolean isValid(char[] chars) {
		int cnt = 0;
		for (char c : chars) {
			if (c == '(') {
				cnt++;
			} else if (c == ')') {
				cnt--;
			}
			
			if (cnt < 0) {
				return false;
			}
		}
		return cnt == 0;
	}
}
