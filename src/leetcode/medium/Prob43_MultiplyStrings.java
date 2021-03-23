package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Prob43_MultiplyStrings {

	public static void main(String[] args) {
		// System.out.println(mul("123", '6'));
		// System.out.println(multiply("123", "456"));
		// System.out.println(multiply("2", "3"));
		// System.out.println(multiply("123456789", "987654321"));
		System.out.println(multiply("3866762897776739956", "15975363164662"));

	}

	static public String multiply(String num1, String num2) {
		if (num1.equalsIgnoreCase("0") || num2.equalsIgnoreCase("0")) {
			return "0";
		}
		int len = 0;
		List<String> toAdd = new ArrayList<>();
		num2 = new StringBuilder(num2).reverse().toString();
		for (char c : num2.toCharArray()) {
			StringBuilder sbr = new StringBuilder(mul(num1, c));
			for (int x = 0; x < len; x++) {
				sbr.append("0");
			}
			len++;
			toAdd.add(sbr.toString());
		}
		// System.out.println(toAdd);

		StringBuilder res = new StringBuilder("0");
		for (String eachStr : toAdd) {
			res = add(res.toString(), eachStr);
			// System.out.println(res);
		}
		return res.toString();
	}

	private static StringBuilder add(String a, String b) {
		// System.out.println("Adding " + a + " + " + b);
		int i = a.length() - 1;
		int j = b.length() - 1;

		int carry = 0;
		List<Integer> l = new ArrayList<>();
		while (i >= 0 && j >= 0) {
			int left = a.charAt(i) - '0';
			int right = b.charAt(j) - '0';
			int tempSum = (left + right + carry) % 10;
			carry = (left + right + carry) / 10;
			l.add(0, tempSum);
			i--;
			j--;
		}

		if (i < 0 && j >= 0) {
			while (j >= 0) {
				int left = 0;
				int right = b.charAt(j) - '0';
				int tempSum = (left + right + carry) % 10;
				carry = (left + right + carry) / 10;
				l.add(0, tempSum);
				j--;
			}
		}

		if (i >= 0 && j < 0) {
			while (i >= 0) {
				int left = a.charAt(i) - '0';
				int right = 0;
				int tempSum = (left + right + carry) % 10;
				carry = (left + right + carry) / 10;
				l.add(0, tempSum);
				i--;
			}
		}

		if (carry > 0) {
			l.add(0, carry);
		}
		StringBuilder res = new StringBuilder();
		for (Integer ii : l) {
			res.append(ii);
		}
		return res;
	}

	private static String mul(String num1, char c) {
		StringBuilder sbr = new StringBuilder();
		long carry = 0;
		for (char x : new StringBuilder(num1).reverse().toString().toCharArray()) {
			long temp = carry + ((x - '0') * (c - '0'));
			long mull = temp % 10;
			carry = temp / 10;
			sbr.append(mull);
		}

		if (carry > 0) {
			sbr.append(carry);
		}
		return sbr.reverse().toString();
	}
}
