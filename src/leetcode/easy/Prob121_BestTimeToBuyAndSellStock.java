package leetcode.easy;

public class Prob121_BestTimeToBuyAndSellStock {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));
		System.out.println(maxProfit(new int[] { 7, 6, 4, 3, 1 }));
	}

	// 7,1,5,3,6,4
	static public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int elem : prices) {
			min = Math.min(elem, min);
			max = Math.max(max, elem - min);
		}
		return max;
	}
}
