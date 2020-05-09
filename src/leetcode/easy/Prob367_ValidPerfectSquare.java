package leetcode.easy;

public class Prob367_ValidPerfectSquare {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(14));
	}

	public static boolean isPerfectSquare(int num) {
		if (num <= 1) {
			return true;
		}
		int lowerLimit = 1;
		int higherLimit = num;
		while (lowerLimit <= higherLimit) {

			int midLimit = lowerLimit + (higherLimit - lowerLimit) / 2;
			if (midLimit * midLimit == num) {
				return true;
			}

			int div = num / midLimit;

			if (div >= midLimit) {
				lowerLimit = midLimit + 1;
			} else {
				higherLimit = midLimit - 1;
			}
		}
		return false;
	}

}
