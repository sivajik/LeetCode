package leetcode.easy;

public class Prob1287_WithMoreThan25Per {

	public static void main(String[] args) {
		System.out.println(findSpecialInteger(new int[] { 1, 2, 2, 6, 6, 6, 6, 6, 7, 10 }));
	}

	public static int findSpecialInteger(int[] a) {
		int twenPer = (int) (a.length * (0.25));
		for (int i = 0; i < a.length; i++) {
			if (a[i] == a[i + twenPer]) {
				return a[i];
			}
		}
		return -1;
	}
}
