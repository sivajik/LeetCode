package leetcode.thirtydays.april;

import java.util.Arrays;

public class Day15_ProductOfArray {

	public static void main(String[] args) {
		System.out.println(Arrays.toString((productExceptSelf(new int[] { 1, 2, 3, 4 }))));
	}

	public static int[] productExceptSelf(int[] nums) {

		int length = nums.length;

		int[] leftArray = new int[length];
		int[] rightArray = new int[length];

		int[] answer = new int[length];

		leftArray[0] = 1;
		for (int i = 1; i < length; i++) {
			leftArray[i] = nums[i - 1] * leftArray[i - 1];
		}

		rightArray[length - 1] = 1;
		for (int i = length - 2; i >= 0; i--) {
			rightArray[i] = nums[i + 1] * rightArray[i + 1];
		}

		for (int i = 0; i < length; i++) {
			answer[i] = leftArray[i] * rightArray[i];
		}

		return answer;
	}

	public static int[] productExceptSelfWorstApproach(int[] nums) {
		int[] result = new int[nums.length];

		int prod = 1;
		for (int num : nums) {
			if (num != 0) {
				prod *= num;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				result[i] = 0;
			} else {
				result[i] = prod / nums[i];
			}
		}
		return result;
	}
}
