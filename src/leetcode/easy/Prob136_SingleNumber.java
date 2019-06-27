package leetcode.easy;

public class Prob136_SingleNumber {

	public static void main(String[] args) {
		System.out.println(singleNumber(new int[] { 2, 2, 1 }));
		System.out.println(singleNumber(new int[] { 4, 1, 2, 1, 2 }));

	}

	public static int singleNumber(int[] nums) {
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			result = result ^ nums[i];
		}
		return result;
	}
}
