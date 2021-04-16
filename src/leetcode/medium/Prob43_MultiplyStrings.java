package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob43_MultiplyStrings {

	public static void main(String[] args) {
		// System.out.println(multiply("123", "6"));
		System.out.println(multiply("123", "456"));
		// System.out.println(multiply("2", "3"));
		// System.out.println(multiply("123456789", "987654321"));
		// System.out.println(multiply("3866762897776739956", "15975363164662"));

	}

	// a better one is here:
	// https://leetcode.com/problems/multiply-strings/discuss/1005658/Simple-multiplication-O(n*m)-or-Java-3ms-or-90-faster

	static public String multiply(String s, String t) {
		if (s == null || t == null) {
			return null;
		}

		if (s.equalsIgnoreCase("0") || t.equalsIgnoreCase("0")) {
			return "0";
		}

		int n = s.length();
		int m = t.length();
		int[] res = new int[m + n]; // 12 X 6
		for (int i = m - 1; i >= 0; i--) {
			int a = t.charAt(i) - '0';
			for (int j = n - 1; j >= 0; j--) {
				int b = s.charAt(j) - '0';
				int multiple = a * b;
				
				int pos1 = i+j+1;
				int pos2 = i+j;
				
				res[pos1] += multiple % 10;
				res[pos2] += multiple / 10;
			}
		}
		System.out.println(Arrays.toString(res));
		StringBuilder builder = new StringBuilder();
        int carry = 0;
        for(int i=res.length-1 ; i>=0 ; i--) {

            int value = res[i] + carry;
            carry = value / 10;
            res[i] = value % 10;

            if(i > 0 || res[i] != 0)
                builder.append(res[i]);
        }
        
        return builder.reverse().toString();

	}

	static public String multiply1(String num1, String num2) {
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
			carry = temp / 10;
			sbr.append(temp % 10);
		}

		if (carry > 0) {
			sbr.append(carry);
		}
		return sbr.reverse().toString();
	}
}
