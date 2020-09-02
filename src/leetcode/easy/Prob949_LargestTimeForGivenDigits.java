package leetcode.easy;

import java.util.Arrays;

public class Prob949_LargestTimeForGivenDigits {

	public static void main(String[] args) {
		System.out.println("result: " + largestTimeFromDigits(new int[] { 1, 2, 3, 4 }));
/*		System.out.println("result: " + largestTimeFromDigits(new int[] { 5, 5, 5, 5 }));
		System.out.println("result: " + largestTimeFromDigits(new int[] { 0, 0, 0, 0 }));
		System.out.println("result: " + largestTimeFromDigits(new int[] { 1, 2, 9, 3 }));
*/		
	}

	static int time = -1;

	static public String largestTimeFromDigits(int[] A) {
		time = -1;
		permutate(A, 0);
		if (time == -1) {
			return "";
		}
		return String.format("%02d:%02d", time / 60, time % 60);
	}

	private static void permutate(int[] a, int start) {
		if (start == a.length) {
			calcTime(a);
			return;
		}

		for (int i = start; i < a.length; i++) {
			swap(a, i, start);
			permutate(a, start + 1);
			swap(a, i, start);
		}
	}

	private static void calcTime(int[] a) {
		System.out.println(Arrays.toString(a));
		int h = a[0] * 10 + a[1];
		int m = a[2] * 10 + a[3];
		if (h < 24 && m < 60) {
			time = Math.max(time, h * 60 + m);
		}	

	}

	private static void swap(int[] a, int i, int loc) {
		if (i != loc) {
			int temp = a[i];
			a[i] = a[loc];
			a[loc] = temp;
		}
	}
}
