package leetcode.medium;

public class Prob1680_ConcatenationOfConsecutiveBinaryNumbers {

	public static void main(String[] args) {
		System.out.println(concatenatedBinary(3));
		System.out.println(concatenatedBinary(12));
	}

	static public int concatenatedBinary(int n) {
		int mod = 1000000000 + 7;
		int res = 0;
		for (int i = 1; i <= n; i++) {
			String binStr = Integer.toBinaryString(i);
			for (char c : binStr.toCharArray()) {
				res = ((res * 2) + (c - '0')) % mod;
			}
		}
		return res;
	}
}
//1 10 11