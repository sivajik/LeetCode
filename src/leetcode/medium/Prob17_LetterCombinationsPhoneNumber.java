package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob17_LetterCombinationsPhoneNumber {

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));
		System.out.println(letterCombinations(""));
		System.out.println(letterCombinations("2"));
	}

	static public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return res;
		}
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");

		helper(digits, map, 0, "", res);

		return res;
	}

	// 23 :
	private static void helper(String digits, Map<Integer, String> map, int currPos, String currStr, List<String> res) {
		if (currPos == digits.length()) {
			res.add(currStr);
			return;
		}

		int digit = digits.charAt(currPos) - '0'; // 2
		for (char c : map.get(digit).toCharArray()) {
			helper(digits, map, currPos + 1, currStr + c, res);
		}

	}
}
