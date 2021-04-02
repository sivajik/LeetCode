package leetcode.medium;

public class PRob1780_CheckIfNumberisaSumofPowersofThree {

	public static void main(String[] args) {
		System.out.println(checkPowersOfThree(11));
		// System.out.println(checkPowersOfThree(79));
	}

	static public boolean checkPowersOfThree(int n) {
		int prev = -1;
		while (n > 0) {
			int log = (int) Math.floor(Math.log10(n) / Math.log10(3));
			n = n - (int) Math.pow(3, log);

			// ordering matters here... first check this..
			if (prev == log) {
				return false;
			}

			// and then this...
			if (n == 0) {
				return true;
			}

			prev = log;
		}

		return false;
	}
}
