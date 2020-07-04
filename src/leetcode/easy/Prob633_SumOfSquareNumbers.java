package leetcode.easy;

public class Prob633_SumOfSquareNumbers {

	public static void main(String[] args) {
		for (int i = 1; i < 101; i++) {
			System.out.println(i + " -> " + judgeSquareSum(i));
		}

	}

	static public boolean judgeSquareSum(int c) {
		int a = 0;
		int b = (int) Math.sqrt(c);

		while (a <= b) {
			int aSqPlusbSq = (a * a) + (b * b);
			
			if (aSqPlusbSq == c) {
				return true;
			} else if (aSqPlusbSq < c) {
				a++;
			} else {
				b--;
			}
		}
		return false;
	}
}
