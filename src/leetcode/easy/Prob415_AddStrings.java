package leetcode.easy;

public class Prob415_AddStrings {

	public static void main(String[] args) {
		System.out.println(addStrings("1", "999"));

	}
	public static String addStrings(String num1, String num2) {
	       
		StringBuilder sbldr = new StringBuilder();

		String bigger = num1, smaller = num2;
		if (num1.length() < num2.length()) {
			smaller = num1;
			bigger = num2;
		}

		char bg, sm;
		int carry = 0;
		for (int i = 0; i < bigger.length(); i++) {
			if (i < bigger.length()) {
				bg = bigger.charAt(bigger.length() - i - 1);
			} else {
				bg = '0';
			}
			if (i < smaller.length()) {
				sm = smaller.charAt(smaller.length() - i - 1);
			} else {
				sm = '0';
			}

			int temp = (bg - '0') + (sm - '0') + carry;
			if (temp > 9) {
				carry = 1;
				temp = temp % 10;
			} else {
				carry = 0;
			}
			sbldr.append((char) (temp + (int) '0'));
		}
		if (carry == 1) {
			return "1" + sbldr.reverse().toString();
		} else {
			return sbldr.reverse().toString();
		}
	 
    }
}
