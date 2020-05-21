package leetcode.easy;

public class Prob258_AddDigits {

	public static void main(String[] args) {
		System.out.println(addDigits(260314));
		System.out.println(addDigits(1371981));
		System.out.println(addDigits(29101986));
		System.out.println(addDigits(6101956));
		
		System.out.println(addDigits(13071982));

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