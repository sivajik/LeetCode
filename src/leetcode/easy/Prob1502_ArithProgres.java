package leetcode.easy;

import java.util.Arrays;

public class Prob1502_ArithProgres {

	public static void main(String[] args) {
		// System.out.println(canMakeArithmeticProgression(new int[] { 1, 15, 3 }));
		System.out.println(canMakeArithmeticProgression(new int[] { 126,183,259,31,145,202,221,278,50,107,164,12,88,-7,240,69}));
	}

	static public boolean canMakeArithmeticProgression(int[] arr) {
		Arrays.sort(arr);
		if (arr.length < 3) {
			return true;
		}

		int diff = Math.abs(arr[0] - arr[1]);
		for (int i = 1; i < arr.length; i++) {
			if (Math.abs(arr[i] - arr[i - 1]) != diff) {
				return false;
			}
		}
		return true;
	}
}
