package leetcode.easy;

public class Prob1295_NuimbersEvenDigits {

	public static void main(String[] args) {
		System.out.println(findNumbers(new int[] { 12, 345, 2, 6, 7896 }));
		System.out.println(findNumbers(new int[] { 12, 34, 20, 60, 78969 }));
		System.out.println(findNumbers(new int[] { 112, 345, 2, 6, 17896 }));
	}

	public static int findNumbers(int[] nums) {
		int count = 0;
		for (int num : nums) {
			if ((num >= 10 && num <= 99) || (num >= 1000 && num <= 9999) || num == 100000) {
				count++;
			}
		}
		return count;
	}
}
