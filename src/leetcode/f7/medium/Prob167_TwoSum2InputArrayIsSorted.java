package leetcode.f7.medium;

import java.util.Arrays;

public class Prob167_TwoSum2InputArrayIsSorted {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 7, 11, 15 }, 9)));
		System.out.println(Arrays.toString(twoSum(new int[] { 5, 25, 75 }, 100)));
	}

	public static int[] twoSum(int[] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			int elem = numbers[i];
			int lookFor = target - elem;
			int foundAt = contains(numbers, i + 1, numbers.length - 1, lookFor);
			if (foundAt != -1) {
				return new int[] { i + 1, foundAt + 1 };
			}
		}
		return null;
	}

	private static int contains(int[] numbers, int l, int h, int lookFor) {
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (numbers[mid] == lookFor) {
				return mid;
			}

			if (numbers[mid] < lookFor) {
				l = mid + 1;
			} else {
				h = mid - 1;
			}
		}
		return -1;
	}

}
