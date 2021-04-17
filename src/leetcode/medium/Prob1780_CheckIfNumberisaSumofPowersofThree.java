package leetcode.medium;

public class Prob1780_CheckIfNumberisaSumofPowersofThree {

	public static void main(String[] args) {
		System.out.println(checkPowersOfThree(11));
		// System.out.println(checkPowersOfThree(79));
	}

	static public boolean checkPowersOfThree(int n) {
		if (n == 0 || n == 1) {
			return true;
		}
		// any number with %3 have 3 options: 0, 1, 2
		// if 0 -> yeah we can represent
		// if 1 -> yeah 3 to the power or zero
		// if 2 -> no wa hose.
		int remaining = n % 3;

		if (remaining == 2) {
			return false;
		}
		if (remaining == 1) {
			n -= 1;
		}
		n = n / 3;
		return checkPowersOfThree(n);
	}

	static public boolean checkPowersOfThree1(int n) {
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
