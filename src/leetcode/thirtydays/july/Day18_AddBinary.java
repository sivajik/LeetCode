package leetcode.thirtydays.july;

public class Day18_AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String addBinary(String a, String b) {

		int diff = a.length() - b.length();
		String padd = "";
		for (int i = 0; i < Math.abs(diff); i++) {
			padd += "0";
		}

		if (diff < 0) {
			// a needs to be padded with left most zeros.
			a = padd + a;
		} else if (diff > 0) {
			// b needs to be padded with left most zeros.
			b = padd + b;
		}

		if (a.length() == b.length()) {
			char[] aBits = a.toCharArray();
			char[] bBits = b.toCharArray();

			char[] cBits = new char[aBits.length];
			int carryOver = 0;
			for (int i = aBits.length - 1; i >= 0; i--) {
				int x = (int) aBits[i] - 48;
				int y = (int) bBits[i] - 48;

				int sum = x + y;
				if (sum == 1) {
					if (carryOver == 0) {
						sum = 1;
						carryOver = 0;
					} else if (carryOver == 1) {
						sum = 0;
						carryOver = 1;
					}
				} else if (sum == 2) {
					if (carryOver == 0) {
						sum = 0;
						carryOver = 1;
					} else if (carryOver == 1) {
						sum = 1;
						carryOver = 1;
					}
				} else if (sum == 0) {
					if (carryOver == 0) {
						sum = 0;
						carryOver = 0;
					} else if (carryOver == 1) {
						sum = 1;
						carryOver = 0;
					}
				}
				cBits[i] = (char) (sum + 48);
			}
			return carryOver == 1 ? "1" + new String(cBits) : new String(cBits);
		}
		return null;

	}
}
