package leetcode.easy;

public class Prob326_IsPowerOf3 {

	public static void main(String[] args) {
		System.out.println(isPowerOfThree(27));
		System.out.println(isPowerOfThree(0));
		System.out.println(isPowerOfThree(9));
		System.out.println(isPowerOfThree(45));

	}

	public static boolean isPowerOfThree(int n) {

		if (n == 0) {
			return false;
		}
		if (n == 1) {
			return true;
		} else {
			return n % 3 == 0 && isPowerOfThree(n / 3);
		}

	}
}
