package leetcode.revision.week02;

public class P560_SubarraySumEqualsK {

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[] { 1, 1, 1 }, 2));
		System.out.println(subarraySum(new int[] { 1, 2, 3 }, 3));
	}

	static public int subarraySum(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int count = 0;

		int[] sumArray = new int[nums.length];
		sumArray[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sumArray[i] = sumArray[i - 1] + nums[i];
		}

		for (int i = 0; i < nums.length; i++) {
			int currSum = sumArray[i];
			if (currSum == k) {
				count++;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (sumArray[j] - currSum == k) {
					count++;
				}
			}

		}
		return count;
	}
}