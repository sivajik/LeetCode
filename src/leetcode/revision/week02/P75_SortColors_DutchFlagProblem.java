package leetcode.revision.week02;

import java.util.Arrays;

public class P75_SortColors_DutchFlagProblem {
	public static void main(String[] args) {
		sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
		sortColors(new int[] { 2, 0, 2, 2, 0, 2 });
		sortColors(new int[] { 0, 0, 0, 0, 0 });
		sortColors(new int[] { 1 });
		sortColors(new int[] { 2, 0, 2, 1, 1, 0, 0, 1, 2, 0, 1, 2 });
	}

	private static void sortColors(int[] a) {
		int low = 0;
		int mid = 0;
		int high = a.length - 1;

		while (mid <= high) {
			if (a[mid] == 0) {
				swap(a, low, mid);
				low++;
				mid++;
			} else if (a[mid] == 1) {
				mid++;
			} else if (a[mid] == 2) {
				swap(a, mid, high);
				high--;
			}
		}
		System.out.println(Arrays.toString(a));
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
