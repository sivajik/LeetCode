package leetcode.easy;

public class Prob268_MissingNumber {

	public static void main(String[] args) {
		System.out.println(missingNumber(new int[] { 9, 6, 4, 2, 3, 5, 7, 0, 1 }));
	}

	public static int missingNumber(int[] nums) {
		int n = nums.length;
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		return ((n * (n + 1)) / 2) - sum;
	}
}
