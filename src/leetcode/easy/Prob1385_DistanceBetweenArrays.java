package leetcode.easy;

import java.util.Arrays;

public class Prob1385_DistanceBetweenArrays {

	public static void main(String[] args) {
		//System.out.println(findTheDistanceValue(new int[] { 4, 5, 8 }, new int[] { 1, 8, 9, 10 }, 2));
		System.out.println(findTheDistanceValue(new int[] { 4,-3,-7,0,-10 }, new int[] { 10 }, 69));

	}
	
	static public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		// 4 5 8
		Arrays.sort(arr2); // 1 8 9 10
		int isProbableElement = 0;

		for (int elem : arr1) {
			int l = 0;
			int r = arr2.length - 1;

			isProbableElement++;

			while (l <= r) {
				int mid = l + (r - l) / 2;
				if (Math.abs(elem - arr2[mid]) <= d) {
					isProbableElement--;
					break;
				}
				if (arr2[mid] == elem)
					break;
				else if (elem < arr2[mid])
					r = mid - 1;
				else
					l = mid + 1;
			}
		}

		return isProbableElement;
	}
}
