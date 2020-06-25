package leetcode.medium;

public class Prob96_UniqueBinarySearchTrees {

	public static void main(String[] args) {
		System.out.println(numTrees(3));
		System.out.println(numTrees(11));
	}

	static public int numTrees(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				dp[i] += dp[j] * dp[i - j - 1];
			}
		}
		return dp[n];
	}

	static java.util.Map<Integer, Long> map = new java.util.HashMap<>();

	static public int numTrees1(int n) {
		long a = fact(2 * n);
		long b = fact(n);
		long c = fact(n + 1);
		return (int) (a / (b * c));
	}

	static private long fact(int n) {
		if (n == 0 || n == 1) {
			map.put(n, 1l);
			return 1;
		}
		for (int i = 2; i <= n; i++) {
			long res = i * fact(i - 1);
			map.put(i, res);
		}
		return map.get(n);
	}
}
