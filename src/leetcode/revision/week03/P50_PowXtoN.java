package leetcode.revision.week03;

public class P50_PowXtoN {

	public static void main(String[] args) {
		System.out.println(myPow(2, 10));
		System.out.println(myPow(2.1, 3));
		System.out.println(myPow(2, -2));
		System.out.println(myPow(2, -2));
	}

	static public double myPow(double x, int n) {
		if (n > 0) {
			return power(x, n);
		} else {
			return 1 / power(x, n);
		}
	}

	static private double power(double x, int n) {
		if (n == 0)
			return 1;
		if (x == 0.0)
			return x;
		if (n == 1)
			return x;

		double ans = power(x, n / 2);
		if (n % 2 == 0)
			return ans * ans;
		else
			return x * ans * ans;
	}
}
