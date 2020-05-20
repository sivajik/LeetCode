package leetcode.easy;

import java.util.List;

public class Prob448_NumbersDisappearedInArray {

	public static void main(String[] args) {
		System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> l = new java.util.ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			if (nums[val] > 0) {
				nums[val] = -1 * nums[val];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				l.add(i + 1);
			}
		}
		return l;
	}
}
