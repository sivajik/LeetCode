package leetcode.easy;

public class Prob167_TwoSumPart2 {

	public static void main(String[] args) {
		System.out.println(java.util.Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(java.util.Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 17)));
	}

	public static int[] twoSum(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			int num = numbers[i];
			int lookFor = target - num;
			int location = binSearch(numbers, i + 1, numbers.length - 1, lookFor);
			if (location != -1) {
				return new int[] { i + 1, location + 1 };
			}
		}
		return new int[] {};
	}

	public static int binSearch(int[] nums, int l, int h, int lookFor) {
		while (l <= h) {
			int m = l + (h - l) / 2;
			if (nums[m] == lookFor) {
				return m;
			}
			if (lookFor < nums[m]) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		return -1;
	}
}
