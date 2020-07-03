package leetcode.easy;

import java.util.Arrays;

public class Prob1475_FinalPricesSpecialDiscount {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(finalPrices(new int[] { 8, 4, 6, 2, 3 })));
		System.out.println(Arrays.toString(finalPrices(new int[] { 1, 2, 3, 4, 5 })));
		System.out.println(Arrays.toString(finalPrices(new int[] { 10, 1, 1, 6 })));
	}

	static public int[] finalPrices(int[] prices) {
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < prices.length; j++) {
				if (prices[j] <= prices[i]) {
					prices[i] -= prices[j];
					break;
				}
			}
		}
		return prices;
	}
}
