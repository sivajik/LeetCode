package leetcode.medium;

public class Prob1060_MissingElementinSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static class Solution {
		public int missingElement(int[] nums, int k) {
			int i = 0, j = nums.length - 1;
			while (j - i > 1) {
				int mid = (i + j) / 2;
				int missing = nums[mid] - nums[i] - (mid - i);
				// substract missing ones on the left from k
				if (k > missing) {
					i = mid;
					k -= missing;
				} else {
					j = mid;
				}
			}
			// e.g. [1,4],2 => 1 + 2 = 3
			// [1,4],3 => 1 + 3 + 1 (because 4 is present) = 6
			return nums[i] + k + (nums[i] + k < nums[j] ? 0 : 1);
		}
	}
}
