package leetcode.medium;

public class Prob322_CoinChange {

	public static void main(String[] args) {
		System.out.println(coinChange(new int[] { 1, 2, 3 }, 6));

	}

	static public int coinChange(int[] coins, int amount) {
		if (amount < 1) {
			return 0;
		}
		return coinchange(coins, amount, new int[amount]);
	}

	private static int coinchange(int[] coins, int remaining, int[] count) {
		if (remaining < 0) {
			// not possible
			return -1;
		}

		if (remaining == 0) {
			return 0;
		}
		if (count[remaining - 1] != 0) {
			// 1 based amount, 0 based index
			return count[remaining - 1];
		}
		int min = Integer.MAX_VALUE;
		for (int eachCoin : coins) {
			int res = coinchange(coins, remaining - eachCoin, count);
			if (res >= 0 && res < min) {
				min = 1 + res;
			}
		}
		count[remaining - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return count[remaining - 1];
	}
}
