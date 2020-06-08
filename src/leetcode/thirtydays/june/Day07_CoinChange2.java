package leetcode.thirtydays.june;

public class Day07_CoinChange2 {

	public static void main(String[] args) {
		System.out.println(change(5, new int[] { 1, 2, 5 }));

	}

	static public int change(int amount, int[] coins) {
		int[] combs = new int[amount + 1];
		combs[0] = 1;

		for (int coinValue : coins) {
			for (int currAmount = 1; currAmount <= amount; currAmount++) {
				if (currAmount >= coinValue) {
					combs[currAmount] += combs[currAmount - coinValue];
				}
			}
		}
		return combs[amount];
	}
}
