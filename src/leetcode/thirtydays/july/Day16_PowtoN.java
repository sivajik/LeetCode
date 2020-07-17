package leetcode.thirtydays.july;

public class Day16_PowtoN {

	public static void main(String[] args) {
		System.out.println(myPow(5, -2));
		// System.out.println(myPow(2, 10));
		System.out.println(myPow(-1, -2147483648));

		System.out.println(myPow(-1, Integer.MAX_VALUE));
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

	static public double myPow(double x, int n) {
		return n > 0 ? power(x, n) : 1 / power(x, -n);
	}

}
