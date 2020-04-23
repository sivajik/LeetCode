package leetcode.thirtydays;

public class Day22_SubArraySumEqualstoK {

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));

	}

	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		for (int start = 0; start < nums.length; start++) {
			int tempSum = 0;
			for (int end = start; end < nums.length; end++) {
				tempSum += nums[end];
				if (tempSum == k) {
					count++;
				}
			}
		}
		return count;
	}
}
