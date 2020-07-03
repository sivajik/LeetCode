package leetcode.easy;

public class Prob724_FindPivotIndex {

	public static void main(String[] args) {
		System.out.println(pivotIndex(new int[] { 1, 7, 3, 6, 5, 6 }));

	}

	static public int pivotIndex(int[] nums) {

		int[] left2right = new int[nums.length];
		int[] right2left = new int[nums.length];

		int sum = 0;
		int sumnew = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			left2right[i] = sum;

			sumnew += nums[nums.length - i - 1];
			right2left[nums.length - i - 1] = sumnew;
		}

		int location = -1;

		for (int i = 0; i < nums.length; i++) {
			if (left2right[i] == right2left[i]) {
				return i;
			}
		}

		return location;

	}
}
