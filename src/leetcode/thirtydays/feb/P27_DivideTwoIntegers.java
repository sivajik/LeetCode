package leetcode.thirtydays.feb;

public class P27_DivideTwoIntegers {

	public static void main(String[] args) {
		System.out.println(divide(10, 3));
		System.out.println(divide(10, 2));
		System.out.println(divide(10, 10));
		System.out.println(divide(10, -10));
		System.out.println(divide(-2147483648, 2));

	}

	static public int divide(int dividend, int divisor) {
		if (divisor == 0) {
			throw new RuntimeException("gone..");
		}

		if (dividend == 0) {
			return 0;
		}

		if (dividend == divisor) {
			return 1;
		}

		if (divisor == 1) {
			return dividend;
		}

		if (dividend == -2147483648 && divisor == -1) {
			return 2147483647;
		}

		boolean isPosAns = false;
		if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
			isPosAns = true;
		} else if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			isPosAns = false;
		}

		int cnt = 0;
		int dividend1 = dividend > 0 ? -1 * dividend : dividend;
		int divisor1 = divisor > 0 ? -1 * divisor : divisor;

		while (dividend1 - divisor1 <= 0) {
			dividend1 -= divisor1;
			cnt++;
		}

		return isPosAns ? cnt : -1 * cnt;
	}
}
