package leetcode.easy;

public class Prob1287_WithMoreThan25Per {

	public static void main(String[] args) {
		System.out.println(findSpecialInteger(new int[] { 1, 2, 2, 6, 6, 6, 6, 6, 7, 10 }));
	}

	public static int findSpecialInteger(int[] arr) {
		int twenPer = (int) (arr.length * (0.25));
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == arr[i + twenPer]) {
				return arr[i];
			}
		}
		return -1;
	}
}
