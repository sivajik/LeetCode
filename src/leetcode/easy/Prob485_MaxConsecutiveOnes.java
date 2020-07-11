package leetcode.easy;

public class Prob485_MaxConsecutiveOnes {

	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[] { 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1 }));
		System.out.println(findMaxConsecutiveOnes(new int[] { 0, 0 }));
		System.out.println(findMaxConsecutiveOnes(new int[] { 1, 1, 1, 1 }));
		System.out.println(findMaxConsecutiveOnes(new int[] {}));

	}

	static public int findMaxConsecutiveOnes(int[] nums) {
		int c = 0;
		int localCounter = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				localCounter++;
			} else {
				c = Math.max(c, localCounter);
				localCounter = 0;
			}
		}
		return Math.max(c, localCounter);
	}
}
