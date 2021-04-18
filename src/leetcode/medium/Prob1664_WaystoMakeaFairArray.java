package leetcode.medium;

public class Prob1664_WaystoMakeaFairArray {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.waysToMakeFair(new int[] { 2, 1, 6, 4 }));

	}

	static class Solution {
		public int waysToMakeFair(int[] nums) {

			// https://leetcode.com/problems/ways-to-make-a-fair-array/discuss/998121/Java-simple-and-easy-O(N)-tutorial
			int evenLeft = 0;
			int oddLeft = 0;
			int total = 0;

			int evenRight = 0;
			int oddRight = 0;

			for (int i = 0; i < nums.length; i++) {
				if (i % 2 == 0) {
					evenRight += nums[i];
				} else {
					oddRight += nums[i];
				}
			}

			for (int i = 0; i < nums.length; i++) {
				if (i > 0) {
					if (i % 2 == 0) {
						oddLeft += nums[i - 1];
					} else {
						evenLeft += nums[i - 1];
					}
				}

				if (i % 2 == 0) {
					evenRight -= nums[i];
				} else {
					oddRight -= nums[i];
				}

				if (evenLeft + oddRight == oddLeft + evenRight) {
					total++;
				}
			}
			return total;

		}
	}
}
