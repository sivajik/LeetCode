package leetcode.easy;

import java.util.Arrays;

public class Prob0066_PlusOne {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(plusOne(new int[] { 0 }))); // 1
		System.out.println(Arrays.toString(plusOne(new int[] { 4 }))); // 5
		System.out.println(Arrays.toString(plusOne(new int[] { 9 }))); // 10
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 3 }))); // 124
		System.out.println(Arrays.toString(plusOne(new int[] { 1, 2, 9 }))); // 130
		System.out.println(Arrays.toString(plusOne(new int[] { 4, 3, 2, 1 }))); // 4322
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 8, 9 }))); // 990
		System.out.println(Arrays.toString(plusOne(new int[] { 9, 9, 9 }))); // 1000
	}

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] = digits[i] + 1;
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		int[] newNumber = new int[digits.length + 1];
		newNumber[0] = 1;
		return newNumber;
	}
}
