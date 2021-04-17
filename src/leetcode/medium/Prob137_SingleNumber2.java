package leetcode.medium;

// learned from : https://leetcode.com/problems/single-number-ii/discuss/615069/Java-or-O(n)-or-With-Detailed-explanation
public class Prob137_SingleNumber2 {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 2, 2, 3, 2, 3, 3, 7, 5, 5, 5, 1, 1, 1 }));
		System.out.println(singleNumber(new int[] { 2, 2, 3, 2 }));
	}

	static public int singleNumber(int[] nums) {
		int seenOnce = 0, seenTwice = 0;
		for (int n : nums) {
			seenOnce = ~seenTwice & (seenOnce ^ n);
			seenTwice = ~seenOnce & (seenTwice ^ n);
		}
		return seenOnce;
	}

	static public int singleNumber1(int[] nums) {
		int ans = 0, numOf1sAtPositionI = 0, p = 1;

		for (int i = 0; i < 32; i++) {
			numOf1sAtPositionI = 0;

			for (int j = 0; j < nums.length; j++) {
				int shiftLeft = p << i; // move 1 to i times left in each cycle.

				if ((shiftLeft & nums[j]) != 0) { // 1 exists in bit position i
					numOf1sAtPositionI++;
				}
			}

			// at a particular bit position, if sum%3 == 1 means, take that bit as 1.
			if (numOf1sAtPositionI % 3 == 1) {
				numOf1sAtPositionI = numOf1sAtPositionI % 3;
				ans = ans | (numOf1sAtPositionI << i);
			}
		}
		return ans;
	}
}
