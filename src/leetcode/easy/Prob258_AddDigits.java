package leetcode.easy;

public class Prob258_AddDigits {

	public static void main(String[] args) {
		System.out.println(addDigits(38));
		System.out.println(addDigits(130782));
		System.out.println(addDigits(10));
	}

	public static int addDigits(int num) {
		if (num < 10) {
			return num;
		}
		while (num >= 10) {
			num = sumDigits(num);
		}
		return num;
	}

	private static int sumDigits(int num) {
		int localSum = 0;
		while (num > 0) {
			localSum += num % 10;
			num = num / 10;
		}
		return localSum;
	}
}