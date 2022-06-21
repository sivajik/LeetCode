package leetcode.f7.easy;

public class Prob1108_DefangingAnIPAddress {

	public static void main(String[] args) {
		System.out.println(defangIPaddr("1.1.1.1"));

	}

	public static String defangIPaddr(String address) {
		char[] op = new char[address.length() + 6];
		int i = 0;

		for (char c : address.toCharArray()) {
			if (c == '.') {
				op[i++] = '[';
				op[i++] = c;
				op[i++] = ']';
			} else {
				op[i++] = c;
			}
		}

		return new String(op);
	}

	public static String defangIPaddr1(String address) {
		return address.replaceAll("\\.", "\\[\\.\\]");
	}
}
