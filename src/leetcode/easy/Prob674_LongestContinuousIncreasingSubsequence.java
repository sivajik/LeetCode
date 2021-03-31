package leetcode.easy;

public class Prob674_LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) {
		System.out.println(findLengthOfLCIS(new int[] { 1, 3, 5, 4, 7 }));
		System.out.println(findLengthOfLCIS(new int[] { 2, 2, 2, 2, 2 }));
	}

	static public int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int counter = 1;
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				counter++;
			} else {
				max = Math.max(max, counter);
				counter = 1;
			}
		}
		return Math.max(counter, max);
	}
}
