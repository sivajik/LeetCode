package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prob241_DifferentWaystoAddParentheses {

	public static void main(String[] args) {
		System.out.println(diffWaysToCompute("2*3-4*5"));
		System.out.println(diffWaysToCompute("2-1-1"));
	}

	static private final Map<String, List<Integer>> memory = new HashMap<>();

	static public List<Integer> diffWaysToCompute(String expression) {
		List<Integer> result = new ArrayList<>();

		if (expression.length() == 0) {
			return result;
		}

		if (memory.containsKey(expression)) {
			return memory.get(expression);
		}

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			if (c == '+' || c == '-' || c == '*') {
				String f1 = expression.substring(0, i);
				String f2 = expression.substring(i + 1);

				List<Integer> r1 = diffWaysToCompute(f1);
				List<Integer> r2 = diffWaysToCompute(f2);

				for (int num1 : r1) {
					for (int num2 : r2) {
						int localResult = 0;
						switch (c) {
						case '+':
							localResult = num1 + num2;
							break;
						case '-':
							localResult = num1 - num2;
							break;
						case '*':
							localResult = num1 * num2;
							break;
						}
						result.add(localResult);
					}
				}
			}
		}
		// if expression is just a number
		if (result.size() == 0) {
			result.add(Integer.parseInt(expression));
		}
		memory.put(expression, result);
		return result;
	}
}
