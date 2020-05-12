package leetcode.easy;

import java.util.Arrays;

public class Prob561_ArrayPartition1 {

	public static void main(String[] args) {
		System.out.println(arrayPairSum(new int[] { 1, 4, 3, 2 }));
	}

	public static int arrayPairSum(int[] nums) {
		int sum = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i += 2) {
			sum += nums[i];
		}
		return sum;
	}
}
