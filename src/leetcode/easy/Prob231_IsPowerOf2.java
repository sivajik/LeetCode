package leetcode.easy;

public class Prob231_IsPowerOf2 {

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(16));
		System.out.println(isPowerOfTwo(17));
		System.out.println(isPowerOfTwo(218));
	}

	public static boolean isPowerOfTwo(int n) {
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