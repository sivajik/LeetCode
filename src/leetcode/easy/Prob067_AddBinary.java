package leetcode.easy;

public class Prob067_AddBinary {
	public static void main(String[] args) throws Exception {
		System.out.println(addBinary("1111", "1111"));
		System.out.println(addBinary("11", "1"));
		System.out.println(addBinary("1", "1111"));
		System.out.println(addBinary("1010", "1011"));

		System.out.println(addBinary(
				"10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
				"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));

	}

	public static String addBinary(String a, String b) {
		int diff = a.length() - b.length();
		for (int i = 0; i < Math.abs(diff); i++) {
			if (diff < 0) {
				a = "0" + a;
			} else if (diff > 0) {
				b = "0" + b;
			}
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

				if (sum == 0) {
					if (carryOver == 0) {
						sum = 0;
						carryOver = 0;
					} else if (carryOver == 1) {
						sum = 1;
						carryOver = 0;
					}
				} else if (sum == 1) {
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
				}
				cBits[i] = (char) (sum + 48);
			}
			return carryOver == 1 ? "1" + new String(cBits) : new String(cBits);
		}
		return null;
	}

	public static String addBinary1(String a, String b) {
		Long i = Long.parseLong(a, 2);
		Long j = Long.parseLong(b, 2);
		return Long.toBinaryString(i + j);
	}
}
