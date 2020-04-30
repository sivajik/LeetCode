package leetcode.thirtydays.april;

public class Day05_BestTimeToStock {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 1, 2, 3, 4, 5 }));
	}

	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int j = 0;
		for (int i = j + 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				maxProfit += (prices[i] - prices[i - 1]);
			}
		}
		return maxProfit;
	}
}
