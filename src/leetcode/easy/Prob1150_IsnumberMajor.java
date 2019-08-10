package leetcode.easy;

import java.util.Arrays;

public class Prob1150_IsnumberMajor {

	public static void main(String[] args) {
		System.out.println(isMajorityElement(new int[] {2,4,5,5,5,5,5,6,6}, 5));
		System.out.println(isMajorityElement(new int[] {10,100,101,101}, 101));
		
	}

	public static boolean isMajorityElement(int[] nums, int target) {
		long count = Arrays.stream(nums).filter(x -> x == target).count();
		return count > nums.length / 2;
	}
}
