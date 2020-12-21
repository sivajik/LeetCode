package leetcode.revision.week03;

import java.util.ArrayList;
import java.util.List;

public class Prob6_ZigZagConversion {

	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));

	}

	static public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		List<StringBuilder> l = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			l.add(new StringBuilder());
		}

		boolean topToBottm = true;
		int counter = 0;
		for (char c : s.toCharArray()) {
			if (topToBottm) {
				l.get(counter++).append(c);
				if (counter == numRows) {
					topToBottm = !topToBottm;
					counter = numRows - 1;
				}
			} else {
				l.get(--counter).append(c);
				if (counter == 0) {
					topToBottm = !topToBottm;
					counter = 1;
				}
			}
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			result.append(l.get(i));
		}
		return result.toString();
	}
}
