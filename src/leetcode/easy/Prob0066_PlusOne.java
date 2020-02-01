package leetcode.easy;

import java.util.Arrays;

public class Prob0066_PlusOne {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] { 0 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 4 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 3 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 9 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 8, 9 })));
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9 })));
	}

	public static int[] plusOne(int[] digits) {
		int carryOver = 0, addendum = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			int digit = digits[i];
			addendum = (i == digits.length - 1) ? 1 : 0;
			digits[i] = (digit + addendum + carryOver) % 10;
			carryOver = (digit + addendum + carryOver) / 10;
		}

		if (carryOver != 0) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = carryOver;
			System.arraycopy(digits, 0, newDigits, 1, digits.length);
			return newDigits;
		} else {
			return digits;
		}
	}
}
