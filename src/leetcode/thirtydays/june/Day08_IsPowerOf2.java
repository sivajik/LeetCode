package leetcode.thirtydays.june;

public class Day08_IsPowerOf2 {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(4));

	}

	static public boolean isPowerOfTwo(int n) {

		if (n == 0) {
			return false;
		}
		if (n == 1) {
			return true;
		} else {
			return n % 2 == 0 && isPowerOfTwo(n / 2);
		}

	}
}
