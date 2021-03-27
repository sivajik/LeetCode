package leetcode.easy;

public class Prob204_CountPrimes {

	public static void main(String[] args) {
		System.out.println(countPrimes(10));

	}

	static public int countPrimes(int n) {
		if (n <= 1) {
			return 0;
		}
		int res = 0;
		for (int j = 2; j < n; j++) {
			int count = 0;
			for (int i = 2; i * i <= j; i++) {
				if (j % i == 0) {
					count++;
					break;
				}
			}
			if (count == 0) {
				res++;
			}
		}
		return res;
	}

}
