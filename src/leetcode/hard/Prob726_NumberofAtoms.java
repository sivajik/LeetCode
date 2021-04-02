package leetcode.hard;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Prob726_NumberofAtoms {

	public static void main(String[] args) {
		// System.out.println(countOfAtoms("H2O"));
		System.out.println(countOfAtoms("Mg(OH)2"));
	}

	/*
	 * Given a chemical formula (given as a string), return the count of each atom.
	 * 
	 * The atomic element always starts with an uppercase character, then zero or
	 * more lowercase letters, representing the name.
	 * 
	 * One or more digits representing that element's count may follow if the count
	 * is greater than 1. If the count is 1, no digits will follow. For example, H2O
	 * and H2O2 are possible, but H1O2 is impossible.
	 * 
	 * Two formulas concatenated together to produce another formula. For example,
	 * H2O2He3Mg4 is also a formula.
	 * 
	 * A formula placed in parentheses, and a count (optionally added) is also a
	 * formula. For example, (H2O2) and (H2O2)3 are formulas.
	 * 
	 * Given a formula, return the count of all elements as a string in the
	 * following form: the first name (in sorted order), followed by its count (if
	 * that count is more than 1), followed by the second name (in sorted order),
	 * followed by its count (if that count is more than 1), and so on.
	 * 
	 * 
	 * 
	 */
	static public String countOfAtoms(String formula) {
		int n = formula.length();
		Stack<Map<String, Integer>> stk = new Stack<>();
		stk.push(new TreeMap<>());

		for (int i = 0; i < n;) {
			if (formula.charAt(i) == '(') {
				stk.push(new TreeMap<>());
				i++;
			} else if (formula.charAt(i) == ')') {
				Map<String, Integer> top = stk.pop();
				int iStart = ++i;// do ++i to skip )
				int multip = 1;

				while (i < n && Character.isDigit(formula.charAt(i))) {
					i++;
					// get all numerics...
				}

				if (i > iStart) {
					// convert as a number
					multip = Integer.parseInt(formula.substring(iStart, i));
				}
				for (String c : top.keySet()) {
					// update top elements's multip.
					int currMul = top.get(c);
					stk.peek().put(c, stk.peek().getOrDefault(c, 0) + currMul * multip);
				}

			} else {
				// a char or freq
				int iStart = i++; // if u make ++i you miss first capital letter
				while (i < n && Character.isLowerCase(formula.charAt(i))) {
					i++;
				}
				String name = formula.substring(iStart, i);

				iStart = i;
				while (i < n && Character.isDigit(formula.charAt(i))) {
					i++;
				}

				int multip = 1;
				if (i > iStart) {
					multip = Integer.parseInt(formula.substring(iStart, i));
				}
				stk.peek().put(name, stk.peek().getOrDefault(name, 0) + multip);
			}
		}

		StringBuilder sbr = new StringBuilder();
		for (String name : stk.peek().keySet()) {
			sbr.append(name);
			int times = stk.peek().get(name);
			if (times > 1) {
				sbr.append("" + times);
			}
		}
		return sbr.toString();
	}
}
