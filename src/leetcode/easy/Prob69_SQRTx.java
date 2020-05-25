package leetcode.easy;

public class Prob69_SQRTx {

	public static void main(String[] args) {
		// System.out.println(mySqrt(8));
		// System.out.println(mySqrt(6));
		System.out.println(mySqrt(2147395599));
	}

	public static int mySqrt(int x) {
		if (x == 0) {
			return 0;
		}
		if (x == 1) {
			return 1;
		}
		long low = 1;
		long high = x;
		while (low <= high) {
			long mid = low + (high - low) / 2;
			if (mid * mid == x) {
				return (int) mid;
			} else if (mid * mid < x) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return (int) high;
	}
}