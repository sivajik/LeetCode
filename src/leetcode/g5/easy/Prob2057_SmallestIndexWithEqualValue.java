package leetcode.g5.easy;

public class Prob2057_SmallestIndexWithEqualValue {

	public static void main(String[] args) {
		System.out.println(smallestEqual(new int[] { 0, 1, 2 }));
		System.out.println(smallestEqual(new int[] { 4, 3, 2, 1 }));
		System.out.println(smallestEqual(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 }));

	}

	static public int smallestEqual(int[] nums) {
		int res = Integer.MIN_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (i % 10 == nums[i]) {
				res = i;
				break;
			}
		}

		return res == Integer.MIN_VALUE ? -1 : res;
	}
}
